package frc.team1923.robot.commands.drive;

import frc.team1923.robot.RobotContainer;

public class DriveArcadeCommand extends DriveCommand {
    public DriveArcadeCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.driver.leftStick.y.get();
        double right = this.driver.rightStick.x.get();

        left *= Math.abs(left);
        right *= Math.abs(right);

        this.drive.set(left + right, left - right);
    }
}
