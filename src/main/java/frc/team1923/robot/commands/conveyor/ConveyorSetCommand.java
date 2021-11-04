package frc.team1923.robot.commands.conveyor;

import frc.team1923.robot.RobotContainer;

public class ConveyorSetCommand extends ConveyorCommand {
    private final double speed;

    public ConveyorSetCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);

        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.conveyor.set(this.speed);
    }
}
