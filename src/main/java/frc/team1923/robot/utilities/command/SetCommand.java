package frc.team1923.robot.utilities.command;

public class SetCommand extends SubsystemCommand {
    private final double speed;

    public SetCommand(Subsystem subsystem, double speed) {
        super(subsystem);

        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.subsystem.setSpeed(this.speed);
    }
}
