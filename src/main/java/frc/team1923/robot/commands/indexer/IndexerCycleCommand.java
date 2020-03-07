package frc.team1923.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.CommandGroup;

public class IndexerCycleCommand extends CommandGroup {
    public IndexerCycleCommand(RobotContainer robotContainer) {
        this.addCommands(
            new IndexerSetCommand(robotContainer, -0.75).withTimeout(0.25),
            new WaitCommand(0.1),
            new IndexerSetCommand(robotContainer, 0.75).withTimeout(0.25),
            new WaitCommand(0.1)
        );
    }
}
