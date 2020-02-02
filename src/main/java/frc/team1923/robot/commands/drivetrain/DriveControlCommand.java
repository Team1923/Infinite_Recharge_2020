package frc.team1923.robot.commands.drivetrain;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;

public class DriveControlCommand extends Command<DrivetrainSubsystem> {
    public DriveControlCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.driver.leftStick.y.get();
        double right = this.driver.rightStick.y.get();

        left *= 0.3;
        right *= 0.3;

        this.subsystem.set(left, right);
    }
}
