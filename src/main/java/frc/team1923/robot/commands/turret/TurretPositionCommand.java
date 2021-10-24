package frc.team1923.robot.commands.turret;

import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.command.Command;

public class TurretPositionCommand extends Command<TurretSubsystem> {
    private final double position;

    public TurretPositionCommand(TurretSubsystem turret, double position) {
        super(turret);

        this.position = position;
    }

    @Override
    public void initialize() {
        this.subsystem.setPosition(this.position);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(this.subsystem.getPosition()) < 1; // TODO: check power instead
    }
}
