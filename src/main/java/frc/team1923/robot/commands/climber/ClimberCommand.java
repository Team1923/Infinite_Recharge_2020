package frc.team1923.robot.commands.climber;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.ClimberSubsystem;

public abstract class ClimberCommand extends Command {
    protected final ClimberSubsystem climber;

    protected ClimberCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.climber);
        this.climber = robotContainer.climber;
    }

    @Override
    public void end(boolean interrupted) {
        this.climber.stop();
    }
}
