package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Climber;

public class ClimberSubsystem extends SubsystemBase {
    private CANSparkMax climber = Climber.CLIMBER.create();

    public void set(double speed) {
        this.climber.set(speed);
    }

    public void stop() {
        this.climber.stopMotor();
    }
}
