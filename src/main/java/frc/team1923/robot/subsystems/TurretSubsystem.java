package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Turret;

public class TurretSubsystem extends SubsystemBase {
    private WPI_TalonFX shooter = Turret.SHOOTER.create();

    public void set(double speed) {
        this.shooter.set(speed);
    }

    public void stop() {
        this.shooter.stopMotor();
    }
}
