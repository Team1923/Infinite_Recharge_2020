package frc.team1923.robot.commands.conveyor;

import frc.team1923.robot.RobotContainer;

public class ConveyorControlCommand extends ConveyorCommand {
    public ConveyorControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.conveyor.set(this.operator.rightStick.y.get());
    }
}
