package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Shooter;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_TalonFX shooter = Shooter.SHOOTER.create();

    public ShooterSubsystem() {
        this.shooter.config_kP(0, 0);
        this.shooter.config_kF(0, 0.05);
        this.shooter.configMotionCruiseVelocity(15000);
        this.shooter.configMotionAcceleration(30000);
    }

    public void set(double speed) {
        this.shooter.set(speed);
    }

    public void setPosition(double position) {
        this.shooter.set(ControlMode.MotionMagic, position);
    }

    public void resetPosition() {
        this.shooter.setSelectedSensorPosition(0);
    }

    public double getVelocity() {
        return this.shooter.getSelectedSensorVelocity();
    }

    public void stop() {
        this.shooter.stopMotor();
    }
}
