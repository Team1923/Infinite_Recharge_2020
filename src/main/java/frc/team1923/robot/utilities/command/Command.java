package frc.team1923.robot.utilities.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class Command extends CommandBase {
    private final Subsystem subsystem;

    protected Command(Subsystem subsystem) {
        this.subsystem = subsystem;

        this.addRequirements(subsystem);
    }

    public void setAsDefault() {
        this.subsystem.setDefaultCommand(this);
    }
}
