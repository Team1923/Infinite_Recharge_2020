package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.team1923.robot.Constants.Intake;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.SparkMaxMotor;

public class IntakeSubsystem extends SingleMotorSubsystem<SparkMaxMotor> {
    public IntakeSubsystem() {
        super(Intake.INTAKE);
    }

    private final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(0, 1);

    public void bringDown() {
        this.intakeSolenoid.set(Value.kForward);
    }

    public void bringUp() {
        this.intakeSolenoid.set(Value.kReverse);
    }
}
