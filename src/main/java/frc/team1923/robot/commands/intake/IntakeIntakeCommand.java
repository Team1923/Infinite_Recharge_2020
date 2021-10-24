package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;

public class IntakeIntakeCommand extends IntakeCommand {
    public IntakeIntakeCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.intake.set(this.operator.leftStick.y.get());
    }
}
