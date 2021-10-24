package frc.team1923.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Turret;

public class TurretSubsystem extends SubsystemBase {
    private CANSparkMax turret = Turret.TURRET.create();

    //private CANDigitalInput zeroSensor = this.turret.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyOpen);

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

    public boolean isAtZero() {
        //return this.zeroSensor.get();
        return false;
    }

    public void stop() {
        this.turret.stopMotor();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Turret Is At Zero", this.isAtZero());
    }
}
