package frc.team1923.robot.commands.drivetrain;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;

public abstract class DrivetrainCommand extends Command {
    protected final DrivetrainSubsystem drivetrain;

    protected DrivetrainCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.drivetrain);
        this.drivetrain = robotContainer.drivetrain;
    }

    @Override
    public void end(boolean interrupted) {
        this.drivetrain.stop();
    }
}
