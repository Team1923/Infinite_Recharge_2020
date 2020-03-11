package frc.team1923.robot.subsystems;

import frc.team1923.robot.Constants.Drive;
import frc.team1923.robot.utilities.command.MotorSubsystem;
import frc.team1923.robot.utilities.motor.Motor;
import frc.team1923.robot.utilities.motor.OptimizedMotor;

public class DriveSubsystem extends MotorSubsystem {
    private final Motor left = new OptimizedMotor(Drive.LEFT.create());
    private final Motor right = new OptimizedMotor(Drive.RIGHT.create());

    public DriveSubsystem() {
        this.add(this.left, this.right);
    }

    public void setSpeed(double left, double right) {
        this.left.setSpeed(left);
        this.right.setSpeed(right);
    }

    public void stop() {
        this.left.stop();
        this.right.stop();
    }
}
