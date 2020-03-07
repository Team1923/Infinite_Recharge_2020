package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Drive;

public class DriveSubsystem extends SubsystemBase {
    private WPI_TalonFX left = Drive.LEFT.create();
    private WPI_TalonFX right = Drive.RIGHT.create();

    public void set(double left, double right) {
        this.left.set(Math.max(-1, Math.min(1, left)));
        this.right.set(Math.max(-1, Math.min(1, right)));
    }

    public void stop() {
        this.left.stopMotor();
        this.right.stopMotor();
    }
}
