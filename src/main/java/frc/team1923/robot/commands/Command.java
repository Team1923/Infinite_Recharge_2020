package frc.team1923.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.utilities.Limelight;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

public abstract class Command extends CommandBase {
    private final Subsystem subsystem;

    protected final PS4Controller driver;
    protected final XboxController operator;

    protected final Limelight limelight;

    protected Command(RobotContainer robotContainer, Subsystem subsystem) {
        this.driver = robotContainer.driver;
        this.operator = robotContainer.operator;
        this.limelight = robotContainer.limelight;
        this.subsystem = subsystem;

        if (subsystem != null) {
            this.addRequirements(subsystem);
        }
    }

    public void setAsDefault() {
        if (this.subsystem != null) {
            this.subsystem.setDefaultCommand(this);
        }
    }
}
