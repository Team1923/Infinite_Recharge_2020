package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Conveyor;

public class ConveyorSubsystem extends SubsystemBase {
    private CANSparkMax conveyor = Conveyor.CONVEYOR.create();

    private DigitalInput conveyorProximitySensor = new DigitalInput(0);
    private DigitalInput indexerProximitySensor = new DigitalInput(1);

    public void set(double speed) {
        this.conveyor.set(speed);
    }

    public void stop() {
        this.conveyor.stopMotor();
    }

    public boolean conveyorHasBall() {
        return !this.conveyorProximitySensor.get();
    }

    public boolean indexerHasBall() {
        return !this.indexerProximitySensor.get();
    }
}
