package frc.team1923.robot.utilities.command;

public class SetCommand extends Command {
    private final Subsystem subsystem;
    private final double speed;

    public SetCommand(Subsystem subsystem, double speed) {
        super(subsystem);

        this.subsystem = subsystem;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.subsystem.setSpeed(this.speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.subsystem.stop();
    }
}
