package frc.team1923.robot.utilities.command;

import frc.team1923.robot.utilities.controller.Axis;

public class ControlCommand extends Command {
    private final Subsystem subsystem;
    private final Axis axis;

    public ControlCommand(Subsystem subsystem, Axis axis) {
        super(subsystem);

        this.subsystem = subsystem;
        this.axis = axis;
    }

    @Override
    public void execute() {
        this.subsystem.setSpeed(this.axis.get());
    }

    @Override
    public void end(boolean interrupted) {
        this.subsystem.stop();
    }
}
