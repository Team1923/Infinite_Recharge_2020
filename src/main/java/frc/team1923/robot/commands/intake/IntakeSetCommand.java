package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;

public class IntakeSetCommand extends IntakeCommand {
    private final double speed;

    public IntakeSetCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);

        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.intake.set(this.speed);
    }
}
