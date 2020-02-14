package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;

public class IndexerShiftCommand extends IndexerCommand {
    boolean hasBall;

    public IndexerShiftCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void initialize() {
        this.hasBall = true;
        this.indexer.set(0.75);
    }

    @Override
    public boolean isFinished() {
        boolean hasBall = this.hasBall;
        this.hasBall = this.indexer.hasBall();

        return !hasBall && this.hasBall;
    }
}
