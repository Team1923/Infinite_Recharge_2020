package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.team1923.robot.Constants.Drivetrain;
import frc.team1923.robot.utilities.Subsystem;

public class DrivetrainSubsystem extends Subsystem {
    private WPI_TalonFX left = Drivetrain.LEFT.create();
    private WPI_TalonFX right = Drivetrain.RIGHT.create();

    public void set(double left, double right) {
        this.left.set(left);
        this.right.set(right);
    }

    @Override
    public void stop() {
        this.left.stopMotor();
        this.right.stopMotor();
    }
}
