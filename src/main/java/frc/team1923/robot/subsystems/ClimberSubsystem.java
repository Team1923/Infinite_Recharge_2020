package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.team1923.robot.Constants.Climber;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.TalonFXMotor;

public class ClimberSubsystem extends SingleMotorSubsystem<TalonFXMotor> {
    public ClimberSubsystem() {
        super(Climber.CLIMBER);
    }

    private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(2, 3);

    public void bringDown() {
        this.climberSolenoid.set(Value.kForward);
    }

    public void bringUp() {
        this.climberSolenoid.set(Value.kReverse);
    }
}
