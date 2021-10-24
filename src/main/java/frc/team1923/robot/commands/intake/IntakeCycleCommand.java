package frc.team1923.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.utilities.command.CommandGroup;

public class IntakeCycleCommand extends CommandGroup {
    public IntakeCycleCommand(IntakeSubsystem intake) {
        this.addCommands(
            intake.set(0.3).withTimeout(0.3),
            new WaitCommand(0.3)
        );
    }
}
