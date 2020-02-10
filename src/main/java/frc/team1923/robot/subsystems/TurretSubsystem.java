package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Turret;

public class TurretSubsystem extends SubsystemBase {
    private CANSparkMax turret = Turret.TURRET.create();

    public void set(double speed) {
        this.turret.set(speed);
    }

    public void stop() {
        this.turret.stopMotor();
    }
}
