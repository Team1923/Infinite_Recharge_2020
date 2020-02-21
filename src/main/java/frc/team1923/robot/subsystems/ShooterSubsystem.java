package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Shooter;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_TalonFX shooter = Shooter.SHOOTER.create();

    public void set(double speed) {
        this.shooter.set(speed);
    }

    public void setVelocity(double velocity) {
        this.shooter.set(ControlMode.Velocity, velocity * 2048 / 600.0);
    }

    public double getVelocity() {
        return this.shooter.getSelectedSensorVelocity() * 600 / 2048.0;
    }

    public void stop() {
        this.shooter.stopMotor();
    }
}
