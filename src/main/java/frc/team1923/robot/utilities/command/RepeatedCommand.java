package frc.team1923.robot.utilities.command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PerpetualCommand;

public class RepeatedCommand extends PerpetualCommand {
    public RepeatedCommand(Command command) {
        super(command);
    }

    @Override
    public void execute() {
        this.m_command.execute();

        if (this.m_command.isFinished()) {
            this.m_command.end(false);
            this.m_command.initialize();
        }
    }
}
