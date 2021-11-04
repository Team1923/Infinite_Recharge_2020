package frc.team1923.robot.commands.turret;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;

import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.command.Command;
import frc.team1923.robot.utilities.dashboard.ConfigurableDouble;
import frc.team1923.robot.utilities.vision.Limelight;

public class TurretFollowCommand extends Command<TurretSubsystem> {
    private final TurretSubsystem turret;
    private final Limelight limelight;

    private final Command<TurretSubsystem> goHome;

    private double k;

    public TurretFollowCommand(TurretSubsystem turret, Limelight limelight) {
        super(turret);

        this.turret = turret;
        this.limelight = limelight;

        this.goHome = new TurretPositionCommand(turret, 0);

        new ConfigurableDouble("Movement Correction", k -> this.k = k, 1);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Following", true);

        this.reachedTarget = false;

        this.limelight.enable();

        this.lastX = this.limelight.getX();
    }

    private double position;

    private boolean reachedTarget;

    private static final double RATIO = 147.2727;

    private double lastX;

    @Override
    public void execute() {
        boolean hasValidTarget = this.limelight.hasValidTarget();

        double x = this.limelight.getX();
        double heading = this.turret.getHeading() / 360 % 1;

        if (hasValidTarget) {
            this.position = this.turret.getPosition();
            this.turret.resetHeading();
            // 22 - 120
            // 36 - 1
            //this.reachedTarget = true;
        } else if (!this.reachedTarget && Math.abs(this.position - (heading + x / 360) * RATIO - this.turret.getPosition()) < 15) {
            this.position += 10;
        }

        this.turret.setPosition(this.position - (heading + (this.lastX - x) / 360 * k + x / 360) * RATIO);

        this.lastX = x;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

        this.limelight.disable();

        new FunctionalCommand(() -> {}, () -> {}, inte -> {
            this.goHome.schedule();
        }, () -> true).schedule();
    }
}
