package frc.team1923.robot.commands.controlPanel;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;

public class ControlPanelControlCommand extends Command<ControlPanelSubsystem> {
    public ControlPanelControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.operator.leftTrigger.get();
        double right = this.operator.rightTrigger.get();

        this.subsystem.set(right - left);
    }
}
