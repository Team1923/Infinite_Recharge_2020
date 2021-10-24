package frc.team1923.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Conveyor;

public class ConveyorSubsystem extends SubsystemBase {
    private CANSparkMax conveyor = Conveyor.CONVEYOR.create();

    //private CANDigitalInput conveyorProximitySensor = this.conveyor.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyClosed);
    //private CANDigitalInput indexerProximitySensor = this.conveyor.getForwardLimitSwitch(LimitSwitchPolarity.kNormallyClosed);

    public void set(double speed) {
        this.conveyor.set(speed);
    }

    public void stop() {
        this.conveyor.stopMotor();
    }

    public boolean conveyorHasBall() {
        //return this.conveyorProximitySensor.get();
        return false;
    }

    public boolean indexerHasBall() {
        //return this.indexerProximitySensor.get();
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Conveyor Has Ball", this.conveyorHasBall());
        SmartDashboard.putBoolean("Indexer Has Ball", this.indexerHasBall());
    }
}
