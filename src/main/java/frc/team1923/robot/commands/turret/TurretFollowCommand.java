package frc.team1923.robot.commands.turret;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class TurretFollowCommand extends TurretCommand {
    public TurretFollowCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Following", true);
    }

    @Override
    public void execute() {
        this.turret.setPosition(this.turret.getPosition() - this.limelight.getX() * 381.8 / 360);
    }
}
