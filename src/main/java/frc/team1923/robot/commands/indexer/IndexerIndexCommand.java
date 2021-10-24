package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;

public class IndexerIndexCommand extends IndexerCommand {
    public IndexerIndexCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.indexer.set(this.operator.leftStick.y.get());
    }
}
