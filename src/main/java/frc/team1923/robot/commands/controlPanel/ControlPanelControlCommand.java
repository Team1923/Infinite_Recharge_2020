package frc.team1923.robot.commands.controlPanel;

import frc.team1923.robot.RobotContainer;

public class ControlPanelControlCommand extends ControlPanelCommand {
    public ControlPanelControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.operator.leftTrigger.get();
        double right = this.operator.rightTrigger.get();

        this.controlPanel.set(right - left);
    }
}
