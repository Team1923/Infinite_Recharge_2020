package frc.team1923.robot.commands.drivetrain;

import frc.team1923.robot.RobotContainer;

public class DriveTankCommand extends DrivetrainCommand {
    public DriveTankCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.driver.leftStick.y.get();
        double right = this.driver.rightStick.y.get();

        left = Math.pow(left, 3);
        right = Math.pow(right, 3);

        this.drivetrain.set(left, right);
    }
}
