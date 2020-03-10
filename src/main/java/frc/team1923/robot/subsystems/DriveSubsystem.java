package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Drive;
import frc.team1923.robot.utilities.motor.Motor;
import frc.team1923.robot.utilities.motor.OptimizedMotor;

public class DriveSubsystem extends SubsystemBase {
    private final Motor left = new OptimizedMotor(Drive.LEFT.create());
    private final Motor right = new OptimizedMotor(Drive.RIGHT.create());

    public void setSpeed(double left, double right) {
        this.left.setSpeed(left);
        this.right.setSpeed(right);
    }

    public void stop() {
        this.left.stop();
        this.right.stop();
    }
}
