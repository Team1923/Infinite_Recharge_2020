package frc.team1923.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.team1923.robot.RobotContainer;

public class IndexerCycleCommand extends SequentialCommandGroup {
    public IndexerCycleCommand(RobotContainer robotContainer) {
        this.addCommands(
            new IndexerSetCommand(robotContainer, -0.3).withTimeout(0.25),
            new IndexerSetCommand(robotContainer, 0.3).withTimeout(0.25)
        );
    }
}
