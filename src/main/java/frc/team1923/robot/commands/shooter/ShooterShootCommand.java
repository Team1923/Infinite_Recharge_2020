package frc.team1923.robot.commands.shooter;

import frc.team1923.robot.RobotContainer;

public class ShooterShootCommand extends ShooterCommand {
    private final double speed;

    public ShooterShootCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.shooter.set(this.speed);
    }
}
