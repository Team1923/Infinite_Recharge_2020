package frc.team1923.robot.commands.conveyor;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.ConveyorSubsystem;

public abstract class ConveyorCommand extends Command {
    protected final ConveyorSubsystem conveyor;

    protected ConveyorCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.conveyor);
        this.conveyor = robotContainer.conveyor;
    }

    @Override
    public void end(boolean interrupted) {
        this.conveyor.stop();
    }
}
