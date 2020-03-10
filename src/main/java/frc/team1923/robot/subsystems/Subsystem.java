package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.utilities.motor.Motor;
import frc.team1923.robot.utilities.motor.MotorGroup;
import frc.team1923.robot.utilities.motor.OptimizedMotor;

public abstract class Subsystem extends SubsystemBase {
    private final Motor motor;

    protected Subsystem(MotorGroup motorGroup) {
        this.motor = new OptimizedMotor(motorGroup.create());
    }

    public void setSpeed(double speed) {
        this.motor.setSpeed(speed);
    }

    public void stop() {
        this.motor.stop();
    }

    public double getPosition() {
        return this.motor.getPosition();
    }

    public void resetPosition(double position) {
        this.motor.resetPosition(position);
    }

    public void setPosition(double position) {
        this.motor.setPosition(position);
    }

    public double getVelocity() {
        return this.motor.getVelocity();
    }

    public void setVelocity(double velocity) {
        this.motor.setVelocity(velocity);
    }
}
