package frc.team1923.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Climber;

public class ClimberSubsystem extends SubsystemBase {
    private WPI_TalonFX climber = Climber.CLIMBER.create();

    public void set(double speed) {
        this.climber.set(speed);
    }

    public void stop() {
        this.climber.stopMotor();
    }
}
