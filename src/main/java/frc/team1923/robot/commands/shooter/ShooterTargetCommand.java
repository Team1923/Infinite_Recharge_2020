package frc.team1923.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1923.robot.RobotContainer;

public class ShooterTargetCommand extends ShooterCommand {
    public ShooterTargetCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        final double LIMELIGHT_ANGLE = 23;
        final double LIMELIGHT_HEIGHT = 41.5;
        final double TARGET_HEIGHT = 89.75;

        double distance = (TARGET_HEIGHT - LIMELIGHT_HEIGHT) / Math.tan(Math.toRadians(this.limelight.getY() + LIMELIGHT_ANGLE));
        SmartDashboard.putNumber("Distance", distance);
    }
}
