package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.utilities.Command;

public class TurretShootCommand extends Command {
    private final RobotContainer robotContainer;
    private final double speed;

    public TurretShootCommand(RobotContainer robotContainer, double speed) {
        this.robotContainer = robotContainer;
        this.speed = speed;

        this.addRequirements(robotContainer.turret);
    }

    @Override
    public void initialize() {
        this.robotContainer.turret.set(this.speed);
    }
}
