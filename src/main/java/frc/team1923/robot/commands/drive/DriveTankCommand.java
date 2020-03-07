package frc.team1923.robot.commands.drive;

import frc.team1923.robot.RobotContainer;

public class DriveTankCommand extends DriveCommand {
    public DriveTankCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.driver.leftStick.y.get();
        double right = this.driver.rightStick.y.get();

        left *= Math.abs(left);
        right *= Math.abs(right);

        this.drive.set(left, right);
    }
}
