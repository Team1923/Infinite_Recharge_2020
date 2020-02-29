package frc.team1923.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class ShooterShootCommand extends ShooterCommand {
    private double velocity;

    public ShooterShootCommand(RobotContainer robotContainer, double velocity) {
        super(robotContainer);

        this.velocity = velocity;

        SmartDashboard.putNumber("Target RPM", velocity);
    }

    @Override
    public void initialize() {
        this.velocity = SmartDashboard.getNumber("Target RPM", this.velocity);
        this.shooter.setVelocity(this.velocity);
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Spun Up", this.shooter.getVelocity() > this.velocity - 50);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

        SmartDashboard.putBoolean("Spun Up", false);
    }
}
