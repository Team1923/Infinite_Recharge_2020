package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;

public class TurretFollowCommand extends TurretCommand {
    public TurretFollowCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    @Override
    public void execute() {
        this.turret.setPosition(this.turret.getPosition() - this.limelight.getTx() * 381.8 / 360);
    }
}
