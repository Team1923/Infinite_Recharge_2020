package frc.team1923.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.team1923.robot.utilities.vision.Limelight;

public class TurretLimelight extends Limelight {
    private static final double LIMELIGHT_ANGLE = 23;
    private static final double LIMELIGHT_HEIGHT = 42;
    private static final double TARGET_HEIGHT = 98.25;

    private double distance;
    private int pipeline;

    public TurretLimelight(String table) {
        super(table);

        CommandScheduler.getInstance().addButton(this::updateDistance);
    }

    public TurretLimelight() {
        this("limelight");
    }

    private void updateDistance() {
        if (this.hasValidTarget()) {
            this.distance = (TARGET_HEIGHT - LIMELIGHT_HEIGHT) / Math.tan(Math.toRadians(this.getY() + LIMELIGHT_ANGLE));

            if (this.distance < 200) {
                this.pipeline = 9;
            } else if (this.distance < 350) {
                this.pipeline = 8;
            } else {
                this.pipeline = 7;
            }

            SmartDashboard.putNumber("Distance", distance);
        } else {
            this.pipeline = (this.pipeline - 6) % 3 + 7;
        }

        this.pipeline = 7;

        this.setPipeline(this.pipeline);
    }

    public double getDistance() {
        return this.distance;
    }
}
