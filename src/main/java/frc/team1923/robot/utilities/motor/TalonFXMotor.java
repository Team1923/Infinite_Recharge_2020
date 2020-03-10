package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class TalonFXMotor implements Motor {
    private final TalonFX talonFX;

    public TalonFXMotor(TalonFX talonFX) {
        this.talonFX = talonFX;
    }

    @Override
    public void setSpeed(double speed) {
        this.talonFX.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public double getPosition() {
        return this.talonFX.getSelectedSensorPosition() / 2048.0;
    }

    @Override
    public void resetPosition(double position) {
        this.talonFX.setSelectedSensorPosition((int) Math.round(position * 2048));
    }

    @Override
    public void setPosition(double position) {
        this.talonFX.set(ControlMode.Position, position * 2048);
    }

    @Override
    public void setVelocity(double velocity) {
        this.talonFX.set(ControlMode.Velocity, velocity * 2048 / 600);
    }

    @Override
    public double getVelocity() {
        return this.talonFX.getSelectedSensorVelocity() * 600 / 2048.0;
    }
}
