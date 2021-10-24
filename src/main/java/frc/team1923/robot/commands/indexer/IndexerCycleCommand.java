package frc.team1923.robot.commands.indexer;

import frc.team1923.robot.RobotContainer;

public class IndexerCycleCommand extends IndexerCommand {
    public IndexerCycleCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    private int ticks;

    @Override
    public void initialize() {
        this.ticks = 0;
    }

    @Override
    public void execute() {
        this.indexer.set(this.ticks < 13 ? -0.3 : 0.3);
        ++this.ticks;
    }

    @Override
    public boolean isFinished() {
        return this.ticks >= 26;
    }
}
