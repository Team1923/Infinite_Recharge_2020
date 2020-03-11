package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

public class SparkMaxMotor extends CANSparkMax implements TunableMotor, FollowerMotor<SparkMaxMotor> {
    private final CANEncoder encoder = this.getEncoder();
    private final CANPIDController pidController = this.getPIDController();

    public SparkMaxMotor(int deviceID, boolean invert, boolean brake) {
        super(deviceID, MotorType.kBrushless);

        this.restoreFactoryDefaults();
        this.setInverted(invert);
        this.setIdleMode(brake ? IdleMode.kBrake : IdleMode.kCoast);
    }

    @Override
    public void setSpeed(double speed) {
        this.set(speed);
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
    public void setSoftLimits(double reverse, double forward) {
        this.setSoftLimit(SoftLimitDirection.kForward, (float) forward);
        this.setSoftLimit(SoftLimitDirection.kReverse, (float) reverse);
    }

    @Override
    public void enableSoftLimits(boolean enable) {
        this.enableSoftLimit(SoftLimitDirection.kForward, enable);
        this.enableSoftLimit(SoftLimitDirection.kReverse, enable);
    }

    @Override
    public void setRamp(double rate) {
        this.setOpenLoopRampRate(rate);
        this.setClosedLoopRampRate(rate);
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

    @Override
    public void follow(SparkMaxMotor leader) {
        this.follow((CANSparkMax) leader);
    }
}
