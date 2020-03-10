package frc.team1923.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.team1923.robot.utilities.command.CommandGroup;
import frc.team1923.robot.utilities.command.SetCommand;
import frc.team1923.robot.utilities.command.Subsystem;

public class IndexerCycleCommand extends CommandGroup {
    public IndexerCycleCommand(Subsystem indexer) {
        this.addCommands(
            new SetCommand(indexer, -0.75).withTimeout(0.25),
            new WaitCommand(0.1),
            new SetCommand(indexer, 0.75).withTimeout(0.25),
            new WaitCommand(0.1)
        );
    }
}
