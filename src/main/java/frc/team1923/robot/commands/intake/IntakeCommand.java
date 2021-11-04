package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.IntakeSubsystem;

public abstract class IntakeCommand extends Command {
    protected final IntakeSubsystem intake;

    protected IntakeCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.intake);
        this.intake = robotContainer.intake;
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.stop();
    }
}
