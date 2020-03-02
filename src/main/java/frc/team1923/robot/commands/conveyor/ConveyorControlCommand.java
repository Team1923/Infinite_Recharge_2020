package frc.team1923.robot.commands.conveyor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class ConveyorControlCommand extends ConveyorCommand {
    public ConveyorControlCommand(RobotContainer robotContainer) {
        super(robotContainer);

        SmartDashboard.putBoolean("Indexing", false);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Indexing", false);
    }

    @Override
    public void execute() {
        this.conveyor.set(this.operator.rightStick.y.get());
    }
}
