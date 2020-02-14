package frc.team1923.robot.commands.intake;

import frc.team1923.robot.RobotContainer;

public class IntakeCycleCommand extends IntakeCommand {
    public IntakeCycleCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    private int ticks;

    @Override
    public void initialize() {
        this.ticks = 0;
    }

    @Override
    public void execute() {
        this.intake.set(this.ticks < 13 ? -0.6 : 0.6);
        ++this.ticks;
    }

    @Override
    public boolean isFinished() {
        return this.ticks >= 26;
    }
}
