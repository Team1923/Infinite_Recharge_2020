package frc.team1923.robot.utilities.command;

import frc.team1923.robot.utilities.controller.Axis;

public class ControlCommand extends SubsystemCommand {
    private final Axis axis;

    public ControlCommand(Subsystem subsystem, Axis axis) {
        super(subsystem);

        this.axis = axis;
    }

    @Override
    public void execute() {
        this.subsystem.setSpeed(this.axis.get());
    }
}
