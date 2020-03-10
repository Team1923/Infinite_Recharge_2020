package frc.team1923.robot.commands.drive;

import frc.team1923.robot.subsystems.DriveSubsystem;
import frc.team1923.robot.utilities.controller.Axis;

public class DriveArcadeCommand extends DriveTankCommand {
    public DriveArcadeCommand(DriveSubsystem drive, Axis speed, Axis rotation) {
        super(drive, speed.add(rotation).clamp(), speed.subtract(rotation).clamp());
    }
}
