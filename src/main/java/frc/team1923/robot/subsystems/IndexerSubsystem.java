package frc.team1923.robot.subsystems;

import frc.team1923.robot.Constants.Indexer;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.SparkMaxMotor;

public class IndexerSubsystem extends SingleMotorSubsystem<SparkMaxMotor> {
    public IndexerSubsystem() {
        super(Indexer.INDEXER);
    }
}
