package frc.team1923.robot.commands.conveyor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import frc.team1923.robot.RobotContainer;

public class ConveyorShiftCommand extends SequentialCommandGroup {
    private boolean hasBall;

    public ConveyorShiftCommand(RobotContainer robotContainer) {
        this.addCommands(
            new WaitUntilCommand(() -> robotContainer.conveyor.indexerHasBall()),
            new WaitCommand(0.5),
            new ConveyorSetCommand(robotContainer, 0.5).withInterrupt(() -> {
                boolean hadBall = this.hasBall;
                this.hasBall = robotContainer.conveyor.conveyorHasBall();
                return !hadBall && this.hasBall;
            })
        );
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Indexing", true);

        this.hasBall = true;

        super.initialize();
    }
}
