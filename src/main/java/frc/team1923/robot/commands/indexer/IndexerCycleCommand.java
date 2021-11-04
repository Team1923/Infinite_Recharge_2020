package frc.team1923.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.team1923.robot.subsystems.IndexerSubsystem;
import frc.team1923.robot.utilities.command.CommandGroup;

public class IndexerCycleCommand extends CommandGroup {
    public IndexerCycleCommand(IndexerSubsystem indexer) {
        this.addCommands(
            indexer.set(-0.75).withTimeout(0.25),
            new WaitCommand(0.1),
            indexer.set(0.75).withTimeout(0.25),
            new WaitCommand(0.1)
        );
    }
}
