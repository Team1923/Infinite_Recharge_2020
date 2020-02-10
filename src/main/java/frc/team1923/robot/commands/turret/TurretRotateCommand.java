package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;

public class TurretRotateCommand extends TurretCommand {
    public TurretRotateCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        double left = this.operator.leftTrigger.get();
        double right = this.operator.rightTrigger.get();

        this.turret.set(right - left);
    }
}
