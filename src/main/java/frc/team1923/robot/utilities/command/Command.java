package frc.team1923.robot.utilities.command;

import java.util.Set;

public class Command<T extends Subsystem> implements edu.wpi.first.wpilibj2.command.Command {
    protected final T subsystem;

    protected Command(T subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public Set<edu.wpi.first.wpilibj2.command.Subsystem> getRequirements() {
        return Set.of(this.subsystem);
    }

    public void setAsDefault() {
        this.subsystem.setDefaultCommand(this);
    }

    @Override
    public void end(boolean interrupted) {
        this.subsystem.stop();
    }
}
