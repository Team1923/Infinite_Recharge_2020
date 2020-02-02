package frc.team1923.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.team1923.robot.RobotContainer;

public class TurretShootCommand extends CommandBase {
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

    @Override
    public void end(boolean interrupted) {
        this.robotContainer.turret.stop();
    }
}
