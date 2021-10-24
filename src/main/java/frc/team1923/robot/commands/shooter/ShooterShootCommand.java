package frc.team1923.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1923.robot.RobotContainer;

public class ShooterShootCommand extends ShooterCommand {
    private /* final */ double velocity;

    public ShooterShootCommand(RobotContainer robotContainer, double velocity) {
        super(robotContainer);
        this.velocity = velocity;
        SmartDashboard.putNumber("Target RPM", velocity);
    }

    private long start;
    boolean ended;

    @Override
    public void initialize() {
        this.velocity = SmartDashboard.getNumber("Target RPM", this.velocity);
        this.shooter.setVelocity(this.velocity);

        this.start = System.nanoTime();
        this.ended = false;
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Spun Up", this.shooter.getVelocity() > this.velocity - 50);
        if (this.shooter.getVelocity() > this.velocity - 50 && !this.ended) {
            this.ended = true;
            System.out.println("Spin Up Time @ " + this.velocity + " RPM: " + (System.nanoTime() - this.start) / 1_000_000_000.0);
        }
        //double rumble = this.shooter.getVelocity() > this.velocity * 0.9 ? 0.5 : 0;
        //this.operator.setRumble(rumble);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        SmartDashboard.putBoolean("Spun Up", false);
    }
}
