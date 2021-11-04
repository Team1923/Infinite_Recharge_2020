package frc.team1923.robot.commands.drive;

import frc.team1923.robot.subsystems.DriveSubsystem;
import frc.team1923.robot.utilities.command.Command;
import frc.team1923.robot.utilities.controller.Axis;

public class DriveTankCommand extends Command<DriveSubsystem> {
    private final Axis left, right;

    public DriveTankCommand(DriveSubsystem drive, Axis left, Axis right) {
        super(drive);

        this.left = left;
        this.right = right;
    }

    @Override
    public void execute() {
        this.subsystem.setSpeed(this.left.get(), this.right.get());
    }
}
