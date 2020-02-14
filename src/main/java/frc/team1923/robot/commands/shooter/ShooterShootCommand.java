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
        this.shooter.set(0.4);
    }

    @Override
    public void execute() {
        //this.shooter.set(this.speed);
        //this.shooter.resetPosition();
        //this.shooter.setPosition(1000000);

        double rumble = this.shooter.getVelocity() > 16000 ? 0.5 : 0;
        this.operator.setRumble(rumble);
    }
}
