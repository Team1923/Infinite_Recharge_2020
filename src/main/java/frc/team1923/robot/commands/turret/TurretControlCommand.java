package frc.team1923.robot.commands.turret;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class TurretControlCommand extends TurretCommand {
    public TurretControlCommand(RobotContainer robotContainer) {
        super(robotContainer);

        SmartDashboard.putBoolean("Following", false);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Following", false);
    }

    @Override
    public void execute() {
        double left = this.operator.leftTrigger.get();
        double right = this.operator.rightTrigger.get();

        this.turret.set(left - right);
    }
}
