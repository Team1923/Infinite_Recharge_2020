package frc.team1923.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.utilities.controller.Axis;

public class IntakeIntakeCommand extends frc.team1923.robot.utilities.command.Command<IntakeSubsystem> {
    private final Command subCommand;
    private final Axis axis;

    public IntakeIntakeCommand(IntakeSubsystem intake, Axis axis, Command subCommand) {
        super(intake);

        this.axis = axis;
        this.subCommand = subCommand;
    }

    @Override
    public void initialize() {
        this.subCommand.initialize();
    }

    @Override
    public void execute() {
        double y = this.axis.get();
        if (y == 0) {
            this.subCommand.execute();
        } else {
            this.subsystem.setSpeed(y);
        }
    }

    @Override
    public void end(boolean interrupted) {
        this.subCommand.end(interrupted);
    }
}
