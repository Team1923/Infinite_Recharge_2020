package frc.team1923.robot.commands.drive;

import frc.team1923.robot.subsystems.DriveSubsystem;
import frc.team1923.robot.utilities.command.Command;

public abstract class DriveCommand extends Command {
    protected final DriveSubsystem drive;

    protected DriveCommand(DriveSubsystem drive) {
        super(drive);

        this.drive = drive;
    }

    @Override
    public void end(boolean interrupted) {
        this.drive.stop();
    }
}
