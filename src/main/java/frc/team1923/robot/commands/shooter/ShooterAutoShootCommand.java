package frc.team1923.robot.commands.shooter;

import frc.team1923.robot.TurretLimelight;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.utilities.command.Command;

public class ShooterAutoShootCommand extends Command<ShooterSubsystem> {
    private final TurretLimelight limelight;

    public ShooterAutoShootCommand(ShooterSubsystem shooter, TurretLimelight limelight) {
        super(shooter);

        this.limelight = limelight;
    }

    @Override
    public void execute() {
        this.subsystem.setVelocity(this.limelight.getDistance() * 5.2907 + 2819.77);
    }
}
