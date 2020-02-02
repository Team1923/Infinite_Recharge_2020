package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.utilities.Command;

public class IntakeIntakeCommand extends Command {
    private final RobotContainer robotContainer;
    private final double speed;

    public IntakeIntakeCommand(RobotContainer robotContainer, double speed) {
        this.robotContainer = robotContainer;
        this.speed = speed;

        this.addRequirements(robotContainer.intake);
    }

    @Override
    public void initialize() {
        this.robotContainer.intake.set(this.speed);
    }
}
