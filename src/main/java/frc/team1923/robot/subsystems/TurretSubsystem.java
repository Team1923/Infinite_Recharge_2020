package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Turret;

public class TurretSubsystem extends SubsystemBase {
    private CANSparkMax turret = Turret.TURRET.create();

    public TurretSubsystem() {
        this.turret.getPIDController().setP(0.1);
    }

    public void set(double speed) {
        this.turret.set(speed);
    }

    public void setPosition(double position) {
        this.turret.getPIDController().setReference(position, ControlType.kPosition);
    }

    public double getPosition() {
        return this.turret.getEncoder().getPosition();
    }

    public void resetPosition(double position) {
        this.turret.getEncoder().setPosition(position);
    }

    public void stop() {
        this.turret.stopMotor();
    }
}
