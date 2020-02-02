package frc.team1923.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.team1923.robot.RobotContainer;

public class IntakeIntakeCommand extends CommandBase {
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

    @Override
    public void end(boolean interrupted) {
        this.robotContainer.intake.stop();
    }
}
