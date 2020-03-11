package frc.team1923.robot.utilities.command;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class CommandGroup extends SequentialCommandGroup {
    public RepeatedCommand repeatedly() {
        return new RepeatedCommand(this);
    }
}
