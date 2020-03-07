package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Conveyor;

public class ConveyorSubsystem extends SubsystemBase {
    private CANSparkMax conveyor = Conveyor.CONVEYOR.create();

    private DigitalInput conveyorHasBallSensor = new DigitalInput(Conveyor.CONVEYOR_HAS_BALL_SENSOR);
    private DigitalInput indexerHasBallSensor = new DigitalInput(Conveyor.INDEXER_HAS_BALL_SENSOR);
    private DigitalInput turretHasBallSensor = new DigitalInput(Conveyor.TURRET_HAS_BALL_SENSOR);

    public void set(double speed) {
        this.conveyor.set(speed);
    }

    public void stop() {
        this.conveyor.stopMotor();
    }

    public boolean conveyorHasBall() {
        return !this.conveyorHasBallSensor.get();
    }

    public boolean indexerHasBall() {
        return !this.indexerHasBallSensor.get();
    }

    public boolean turretHasBall() {
        return !this.turretHasBallSensor.get();
    }
}
