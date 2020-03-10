package frc.team1923.robot.utilities.command;

public class SubsystemCommand extends Command {
    protected final Subsystem subsystem;

    public SubsystemCommand(Subsystem subsystem) {
        super(subsystem);

        this.subsystem = subsystem;
    }

    @Override
    public void end(boolean interrupted) {
        this.subsystem.stop();
    }
}
