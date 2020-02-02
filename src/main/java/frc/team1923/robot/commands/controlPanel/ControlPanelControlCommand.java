package frc.team1923.robot.commands.controlPanel;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.utilities.Command;

public class ControlPanelControlCommand extends Command {
    private final RobotContainer robotContainer;

    public ControlPanelControlCommand(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;

        this.addRequirements(robotContainer.controlPanel);
    }

    @Override
    public void execute() {
        double left = this.robotContainer.operator.leftTrigger.get();
        double right = this.robotContainer.operator.rightTrigger.get();

        this.robotContainer.controlPanel.set(right - left);
    }
}