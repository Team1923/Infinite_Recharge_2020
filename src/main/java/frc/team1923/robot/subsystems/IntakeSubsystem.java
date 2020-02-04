package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Intake;

public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax intake = Intake.INTAKE.create();

    public void set(double speed) {
        this.intake.set(speed);
    }

    public void stop() {
        this.intake.stopMotor();
    }
}
