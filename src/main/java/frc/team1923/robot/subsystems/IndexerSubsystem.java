package frc.team1923.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.team1923.robot.Constants.Indexer;

public class IndexerSubsystem extends SubsystemBase {
    private CANSparkMax indexer = Indexer.INDEXER.create();

    public void set(double speed) {
        this.indexer.set(speed);
    }

    public void stop() {
        this.indexer.stopMotor();
    }
}
