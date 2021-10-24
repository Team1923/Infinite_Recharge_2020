package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Shooter;
import frc.team1923.robot.utilities.ConfigurableDouble;

public class ShooterSubsystem extends SubsystemBase {
    private WPI_TalonFX shooter = Shooter.SHOOTER.create();

    private ConfigurableDouble kP = new ConfigurableDouble("Shooter kP", kP -> this.shooter.config_kP(0, kP), 0.2);
    private ConfigurableDouble kF = new ConfigurableDouble("Shooter kF", kF -> this.shooter.config_kF(0, kF), 0.05);

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

    @Override
    public void periodic() {
        //SmartDashboard.putNumber("Shooter Velocity", this.getVelocity());
        SmartDashboard.putString("Shooter Velocity", "" + Math.round(this.getVelocity()));
    }
}
