package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

import frc.team1923.robot.Constants.Conveyor;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.SparkMaxMotor;

public class ConveyorSubsystem extends SingleMotorSubsystem<SparkMaxMotor> {
    public ConveyorSubsystem() {
        super(Conveyor.CONVEYOR);
    }

    private final DigitalInput indexerHasBallSensor = new DigitalInput(Conveyor.INDEXER_HAS_BALL_SENSOR);
    private final DigitalInput conveyorHasBallSensor = new DigitalInput(Conveyor.CONVEYOR_HAS_BALL_SENSOR);
    private final DigitalInput turretHasBallSensor = new DigitalInput(Conveyor.TURRET_HAS_BALL_SENSOR);

    public boolean indexerHasBall() {
        return !this.indexerHasBallSensor.get();
    }

    public boolean conveyorHasBall() {
        return !this.conveyorHasBallSensor.get();
    }

    public boolean turretHasBall() {
        return !this.turretHasBallSensor.get();
    }
}
