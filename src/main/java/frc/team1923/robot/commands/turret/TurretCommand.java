package frc.team1923.robot.commands.turret;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.TurretSubsystem;

public abstract class TurretCommand extends Command {
    protected final TurretSubsystem turret;

    protected TurretCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.turret);
        this.turret = robotContainer.turret;
    }

    @Override
    public void end(boolean interrupted) {
        this.turret.stop();
    }
}
