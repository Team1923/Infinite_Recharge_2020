package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

public class SparkMaxMotor implements TunableMotor {
    private final CANSparkMax sparkMax;
    private final CANEncoder encoder;
    private final CANPIDController pidController;

    public SparkMaxMotor(CANSparkMax sparkMax) {
        this.sparkMax = sparkMax;
        this.encoder = sparkMax.getEncoder();
        this.pidController = sparkMax.getPIDController();
    }

    @Override
    public void setSpeed(double speed) {
        this.sparkMax.set(speed);
    }

    @Override
    public double getPosition() {
        return this.encoder.getPosition();
    }

    @Override
    public void resetPosition(double position) {
        this.encoder.setPosition(position);
    }

    @Override
    public void setPosition(double position) {
        this.pidController.setReference(position, ControlType.kPosition);
    }

    @Override
    public double getVelocity() {
        return this.encoder.getVelocity();
    }

    @Override
    public void setVelocity(double velocity) {
        this.pidController.setReference(velocity, ControlType.kVelocity);
    }

    @Override
    public void setRamp(double rate) {
        this.sparkMax.setOpenLoopRampRate(rate);
        this.sparkMax.setClosedLoopRampRate(rate);
    }

    @Override
    public void setP(double p) {
        this.pidController.setP(p);
    }

    @Override
    public void setI(double i) {
        this.pidController.setI(i);
    }

    @Override
    public void setD(double d) {
        this.pidController.setD(d);
    }

    @Override
    public void setF(double f) {
        this.pidController.setFF(f);
    }
}
