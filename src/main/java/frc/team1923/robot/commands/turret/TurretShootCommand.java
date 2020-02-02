package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.TurretSubsystem;

public class TurretShootCommand extends Command<TurretSubsystem> {
    private final double speed;

    public TurretShootCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.subsystem.set(this.speed);
    }
}
