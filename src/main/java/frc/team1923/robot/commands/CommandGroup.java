package frc.team1923.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.team1923.robot.utilities.command.RepeatedCommand;

public abstract class CommandGroup extends SequentialCommandGroup {
    public RepeatedCommand repeatedly() {
        return new RepeatedCommand(this);
    }
}
