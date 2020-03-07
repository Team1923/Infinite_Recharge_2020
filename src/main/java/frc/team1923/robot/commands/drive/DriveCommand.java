package frc.team1923.robot.commands.drive;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.DriveSubsystem;

public abstract class DriveCommand extends Command {
    protected final DriveSubsystem drive;

    protected DriveCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.drive);
        this.drive = robotContainer.drive;
    }

    @Override
    public void end(boolean interrupted) {
        this.drive.stop();
    }
}
