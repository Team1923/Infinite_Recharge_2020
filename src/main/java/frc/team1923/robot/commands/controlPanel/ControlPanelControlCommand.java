package frc.team1923.robot.commands.controlPanel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.team1923.robot.RobotContainer;

public class ControlPanelControlCommand extends CommandBase {
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

    @Override
    public void end(boolean interrupted) {
        this.robotContainer.controlPanel.stop();
    }
}