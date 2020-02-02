package frc.team1923.robot.commands.drivetrain;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.utilities.Command;

public class DriveControlCommand extends Command {
    private final RobotContainer robotContainer;

    public DriveControlCommand(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;

        this.addRequirements(robotContainer.drivetrain);
    }

    @Override
    public void execute() {
        double left = this.robotContainer.driver.leftStick.y.get();
        double right = this.robotContainer.driver.rightStick.y.get();

        left *= 0.3;
        right *= 0.3;

        this.robotContainer.drivetrain.set(left, right);
    }
}
