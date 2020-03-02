package frc.team1923.robot.commands.climber;

import frc.team1923.robot.RobotContainer;

public class ClimberControlCommand extends ClimberCommand {
    public ClimberControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.climber.set(this.operator.leftStick.x.get());
    }
}
