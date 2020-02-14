package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Indexer;

public class IndexerSubsystem extends SubsystemBase {
    private CANSparkMax indexer = Indexer.INDEXER.create();
    private DigitalInput proximitySensor = new DigitalInput(0);

    public void set(double speed) {
        this.indexer.set(speed);
    }

    public void stop() {
        this.indexer.stopMotor();
    }

    public boolean hasBall() {
        return !this.proximitySensor.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("Sensor", this.hasBall() ? "Yes" : "No");
    }
}
