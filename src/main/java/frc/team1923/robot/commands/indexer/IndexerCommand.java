package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.IndexerSubsystem;

public abstract class IndexerCommand extends Command {
    protected final IndexerSubsystem indexer;

    protected IndexerCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.indexer);
        this.indexer = robotContainer.indexer;
    }

    @Override
    public void end(boolean interrupted) {
        this.indexer.stop();
    }
}
