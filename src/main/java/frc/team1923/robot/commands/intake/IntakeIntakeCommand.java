package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;

public class IntakeIntakeCommand extends IntakeCommand {
    private final double speed;

    public IntakeIntakeCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.intake.set(this.speed);
    }
}
