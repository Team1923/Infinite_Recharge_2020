package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class TalonFXMotor extends TalonFX implements TunableMotor {
    public TalonFXMotor(int deviceID, boolean invert, boolean brake) {
        super(deviceID);

        this.configFactoryDefault();
        this.setInverted(invert);
        this.setNeutralMode(brake ? NeutralMode.Brake : NeutralMode.Coast);
    }

    @Override
    public void setSpeed(double speed) {
        this.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public double getPosition() {
        return this.getSelectedSensorPosition() / 2048.0;
    }

    @Override
    public void resetPosition(double position) {
        this.setSelectedSensorPosition((int) Math.round(position * 2048));
    }

    @Override
    public void setPosition(double position) {
        this.set(ControlMode.Position, position * 2048);
    }

    @Override
    public double getVelocity() {
        return this.getSelectedSensorVelocity() * 600 / 2048.0;
    }

    @Override
    public void setVelocity(double velocity) {
        this.set(ControlMode.Velocity, velocity * 2048 / 600);
    }

    @Override
    public void setSoftLimits(double reverse, double forward) {
        this.configForwardSoftLimitThreshold((int) Math.round(forward * 2048));
        this.configReverseSoftLimitThreshold((int) Math.round(reverse * 2048));
    }

    @Override
    public void enableSoftLimits(boolean enable) {
        this.configForwardSoftLimitEnable(enable);
        this.configReverseSoftLimitEnable(enable);
    }

    @Override
    public void setRamp(double rate) {
        this.configOpenloopRamp(rate);
        this.configClosedloopRamp(rate);
    }

    @Override
    public void setP(double p) {
        this.config_kP(0, p);
    }

    @Override
    public void setI(double i) {
        this.config_kI(0, i);
    }

    @Override
    public void setD(double d) {
        this.config_kD(0, d);
    }

    @Override
    public void setF(double f) {
        this.config_kF(0, f);
    }
}
