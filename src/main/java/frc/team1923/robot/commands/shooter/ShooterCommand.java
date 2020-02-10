package frc.team1923.robot.commands.shooter;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.commands.Command;
import frc.team1923.robot.subsystems.ShooterSubsystem;

public abstract class ShooterCommand extends Command {
    protected final ShooterSubsystem shooter;

    protected ShooterCommand(RobotContainer robotContainer) {
        super(robotContainer, robotContainer.shooter);
        this.shooter = robotContainer.shooter;
    }

    @Override
    public void end(boolean interrupted) {
        this.shooter.stop();
    }
}
