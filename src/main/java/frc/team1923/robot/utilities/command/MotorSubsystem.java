package frc.team1923.robot.utilities.command;

import frc.team1923.robot.utilities.motor.Motor;

public class MotorSubsystem extends Subsystem {
    private final Motor[] motors;

    public MotorSubsystem(Motor... motors) {
        this.motors = motors;
    }

    @Override
    public void stop() {
        for (Motor motor : this.motors) motor.stop();
    }
}
