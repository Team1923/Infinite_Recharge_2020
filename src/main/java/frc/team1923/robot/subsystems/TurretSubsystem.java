package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.team1923.robot.Constants.Turret;
import frc.team1923.robot.utilities.Subsystem;

public class TurretSubsystem extends Subsystem {
    private WPI_TalonFX shooter = Turret.SHOOTER.create();

    public void set(double speed) {
        this.shooter.set(speed);
    }

    @Override
    public void stop() {
        this.shooter.stopMotor();
    }
}
