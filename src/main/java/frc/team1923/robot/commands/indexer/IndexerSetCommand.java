package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;

public class IndexerSetCommand extends IndexerCommand {
    private final double speed;

    public IndexerSetCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);

        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.indexer.set(this.speed);
    }
}
