package frc.team1923.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.indexer.IndexerCycleCommand;
import frc.team1923.robot.utilities.command.CommandGroup;

public class AutoIndexCommand extends CommandGroup {
    private boolean hasBall;

    public int balls;

    private Command after;

    public AutoIndexCommand(RobotContainer robotContainer) {
        this.addCommands(
            new WaitUntilCommand(() -> robotContainer.conveyor.indexerHasBall()).deadlineWith(new IndexerCycleCommand(robotContainer.indexer).repeatedly()),
            new WaitCommand(0.1),
            robotContainer.conveyor.set(0.75).withInterrupt(() -> {
                boolean hadBall = this.hasBall;
                this.hasBall = robotContainer.conveyor.conveyorHasBall();
                return !hadBall && this.hasBall;
            }),
            robotContainer.conveyor.set(-0.2).withInterrupt(() -> {
                return robotContainer.conveyor.conveyorHasBall();
            }),
            new InstantCommand(() -> ++this.balls)
        );

        this.after = robotContainer.conveyor.set(-0.5).withTimeout(0.3);
    }

    @Override
    public void initialize() {
        this.hasBall = true;

        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

        new FunctionalCommand(() -> {}, () -> {}, inte -> {
            if (this.balls == 5) this.after.schedule();
        }, () -> true).schedule();
    }

    public ParallelRaceGroup untilHas(int balls) {
        return this.repeatedly().withInterrupt(() -> this.balls == 5);
    }
}
