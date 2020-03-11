package frc.team1923.robot.subsystems;

import frc.team1923.robot.Constants.Climber;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.TalonFXMotor;

public class ClimberSubsystem extends SingleMotorSubsystem<TalonFXMotor> {
    public ClimberSubsystem() {
        super(Climber.CLIMBER);
    }
}
