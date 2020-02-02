package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.IntakeSubsystem;

public class IntakeIntakeCommand extends Command<IntakeSubsystem> {
    private final double speed;

    public IntakeIntakeCommand(RobotContainer robotContainer, double speed) {
        super(robotContainer);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        this.subsystem.set(this.speed);
    }
}
