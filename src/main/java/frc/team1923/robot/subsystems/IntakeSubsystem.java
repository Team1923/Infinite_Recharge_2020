package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import frc.team1923.robot.Constants.Intake;
import frc.team1923.robot.utilities.Subsystem;

public class IntakeSubsystem extends Subsystem {
    CANSparkMax intake = Intake.INTAKE.create();

    public void set(double speed) {
        this.intake.set(speed);
    }

    @Override
    public void stop() {
        this.intake.stopMotor();
    }
}
