package frc.team1923.robot.utilities.command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RepeatedCommand extends CommandBase {
    private final Command command;

    public RepeatedCommand(Command command) {
        this.command = command;
        this.m_requirements.addAll(command.getRequirements());
    }

    @Override
    public void initialize() {
        this.command.initialize();
    }

    @Override
    public void execute() {
        this.command.execute();

        if (this.command.isFinished()) {
            this.command.end(false);
            this.command.initialize();
        }
    }

    @Override
    public void end(boolean interrupted) {
        this.command.end(interrupted);
    }

    @Override
    public boolean runsWhenDisabled() {
        return this.command.runsWhenDisabled();
    }
}
