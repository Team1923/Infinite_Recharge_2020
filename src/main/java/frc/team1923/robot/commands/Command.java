package frc.team1923.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.team1923.robot.RobotContainer;
import frc.team1923.robot.subsystems.Subsystem;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

import java.lang.reflect.ParameterizedType;

public abstract class Command<S extends Subsystem> extends CommandBase {
    protected final S subsystem;

    protected final PS4Controller driver;
    protected final XboxController operator;

    protected Command(RobotContainer robotContainer) {
        this.driver = robotContainer.driver;
        this.operator = robotContainer.operator;

        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        @SuppressWarnings("unchecked")
        Class<S> subsystem = (Class<S>) superclass.getActualTypeArguments()[0];

        this.subsystem = robotContainer.subsystems.stream()
            .filter(subsystem::isInstance)
            .map(subsystem::cast)
            .findFirst()
            .get();

        this.addRequirements(this.subsystem);
    }

    public void setAsDefault() {
        this.subsystem.setDefaultCommand(this);
    }

    @Override
    public void end(boolean interrupted) {
        this.subsystem.stop();
    }
}
