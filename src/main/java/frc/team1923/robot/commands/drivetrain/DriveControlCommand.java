package frc.team1923.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.team1923.robot.RobotContainer;

public class DriveControlCommand extends CommandBase {
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

    @Override
    public void end(boolean interrupted) {
        this.robotContainer.drivetrain.stop();
    }
}
