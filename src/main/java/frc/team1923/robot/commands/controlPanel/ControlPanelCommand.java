package frc.team1923.robot.commands.controlPanel;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;

public abstract class ControlPanelCommand extends Command {
    protected final ControlPanelSubsystem controlPanel;

    protected ControlPanelCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.controlPanel);
        this.controlPanel = robotContainer.controlPanel;
    }

    @Override
    public void end(boolean interrupted) {
        this.controlPanel.stop();
    }
}
