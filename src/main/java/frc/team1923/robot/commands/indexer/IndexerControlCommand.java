package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;

public class IndexerControlCommand extends IndexerCommand {
    public IndexerControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.indexer.set(this.operator.leftStick.y.get());
    }
}
