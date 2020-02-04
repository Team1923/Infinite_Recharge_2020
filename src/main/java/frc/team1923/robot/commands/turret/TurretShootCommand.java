package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;

public class TurretShootCommand extends TurretCommand {
    private final double speed;

    public TurretShootCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.turret.set(this.speed);
    }
}
