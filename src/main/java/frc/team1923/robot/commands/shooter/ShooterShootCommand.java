package frc.team1923.robot.commands.shooter;

import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.utilities.command.Command;
import frc.team1923.robot.utilities.dashboard.ConfigurableDouble;

public class ShooterShootCommand extends Command<ShooterSubsystem> {
    private double targetVelocity;

    public ShooterShootCommand(ShooterSubsystem shooter) {
        super(shooter);

        new ConfigurableDouble("Target RPM", target -> this.targetVelocity = target);
    }

    @Override
    public void execute() {
        this.subsystem.setVelocity(targetVelocity);
    }
}
