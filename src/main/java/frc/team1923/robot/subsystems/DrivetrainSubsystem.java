package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Drivetrain;

public class DrivetrainSubsystem extends SubsystemBase {
    private WPI_TalonFX left = Drivetrain.LEFT.create();
    private WPI_TalonFX right = Drivetrain.RIGHT.create();

    public void set(double left, double right) {
        this.left.set(left);
        this.right.set(right);
    }

    public void stop() {
        this.left.stopMotor();
        this.right.stopMotor();
    }
}
