package frc.team1923.robot.utilities;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Command extends CommandBase {
    @Override
    public void end(boolean interrupted) {
        this.getRequirements().stream()
            .filter(Subsystem.class::isInstance)
            .map(Subsystem.class::cast)
            .forEach(Subsystem::stop);
    }
}
