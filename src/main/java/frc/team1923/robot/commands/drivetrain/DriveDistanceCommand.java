package frc.team1923.robot.commands.drivetrain;

import frc.team1923.robot.RobotContainer;

public class DriveDistanceCommand extends DrivetrainCommand {
    public DriveDistanceCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    /*
    double target;

    @Override
    public void initialize() {
        //this.drivetrainSubsystem.resetPosition();
        this.drivetrainSubsystem.set(0.3, 0.3);
        double left = drivetrainSubsystem.left[0].getSelectedSensorPosition();
        double right = drivetrainSubsystem.right[0].getSelectedSensorPosition();

        target = left + 50.0 * 2048;
        System.out.println("Starting at " + left);
        System.out.println("Target at " + target);

        //drivetrainSubsystem.left[0].set(ControlMode.MotionMagic, target, DemandType.Neutral, 0);

        double fps = 4;
        double vel = fps / Math.PI / 0.5 * 10.125 * 2048 * 0.1;
        drivetrainSubsystem.left[0].configMotionCruiseVelocity(15000);
        drivetrainSubsystem.left[0].configMotionAcceleration(6000);
        drivetrainSubsystem.right[0].configMotionCruiseVelocity(15000);
        drivetrainSubsystem.right[0].configMotionAcceleration(6000);

        drivetrainSubsystem.left[0].config_kF(0, 0.2);
        drivetrainSubsystem.left[0].config_kP(0, 0.2);
        drivetrainSubsystem.left[0].config_kI(0, 0);
        drivetrainSubsystem.left[0].config_kD(0, 0);

        drivetrainSubsystem.right[0].config_kF(0, 0.2);
        drivetrainSubsystem.right[0].config_kP(0, 0.2);
        drivetrainSubsystem.right[0].config_kI(0, 0);
        drivetrainSubsystem.right[0].config_kD(0, 0);

        drivetrainSubsystem.left[0].set(ControlMode.MotionMagic, target);
        drivetrainSubsystem.right[0].set(ControlMode.MotionMagic, right - 50.0 * 2048);

        // 10.125 ratio

        //this.drivetrainSubsystem.left[0].set(ControlMode.Position, left + 40000);
        //this.drivetrainSubsystem.right[0].set(ControlMode.Position, right + 40000);
    }

    @Override
    public boolean isFinished() {
        //
        double left = drivetrainSubsystem.left[0].getSelectedSensorPosition();

        //return this.drivetrainSubsystem.getLeftPosition() > 22; // 36 in
        return false;
        //return left >= target;
    }
    */
}
