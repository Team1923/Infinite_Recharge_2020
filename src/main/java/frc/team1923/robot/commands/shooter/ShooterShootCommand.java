package frc.team1923.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class ShooterShootCommand extends ShooterCommand {
    public ShooterShootCommand(RobotContainer robotContainer) {
        super(robotContainer);

        SmartDashboard.putNumber("Target RPM", -1337);
        SmartDashboard.putNumber("Target RPM", 0);

        SmartDashboard.putBoolean("Auto Adjust RPM", false);
        SmartDashboard.putBoolean("Auto Adjust RPM", true);
    }

    @Override
    public void execute() {
        double velocity;

        if (SmartDashboard.getBoolean("Auto Adjust RPM", true)) {
            final double LIMELIGHT_ANGLE = 23;
            final double LIMELIGHT_HEIGHT = 42;
            final double TARGET_HEIGHT = 98.25;

            double distance = (TARGET_HEIGHT - LIMELIGHT_HEIGHT) / Math.tan(Math.toRadians(this.limelight.getY() + LIMELIGHT_ANGLE));

            velocity = distance * 5.2907 + 2819.77;

            SmartDashboard.putNumber("Target RPM", velocity);
        } else {
            velocity = SmartDashboard.getNumber("Target RPM", 0);
        }

        this.shooter.setVelocity(velocity);

        SmartDashboard.putBoolean("Spun Up", this.shooter.getVelocity() > velocity - 50);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

        SmartDashboard.putBoolean("Spun Up", false);
    }
}
