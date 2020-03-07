package frc.team1923.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.CommandGroup;

public class IntakeCycleCommand extends CommandGroup {
    public IntakeCycleCommand(RobotContainer robotContainer) {
        this.addCommands(
            new IntakeSetCommand(robotContainer, 0.3).withTimeout(0.3),
            new WaitCommand(0.3)
        );
    }
}
