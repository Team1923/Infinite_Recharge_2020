package frc.team1923.robot.utilities.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class Command extends CommandBase {
    private final Subsystem subsystem;

    protected Command(Subsystem subsystem) {
        this.subsystem = subsystem;

        if (subsystem != null) {
            this.addRequirements(subsystem);
        }
    }

    public void setAsDefault() {
        if (this.subsystem != null) {
            this.subsystem.setDefaultCommand(this);
        }
    }
}
