package frc.team1923.robot.commands.conveyor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.RobotContainer;

public class ConveyorShiftCommand extends ConveyorCommand {
    private boolean hasBall;

    public ConveyorShiftCommand(RobotContainer robotContainer) {
        super(robotContainer);
    }

    private int ticks;

    @Override
    public void initialize() {
        this.hasBall = true;
        this.ticks = 0;

        SmartDashboard.putBoolean("Indexing", true);
    }

    @Override
    public void execute() {
        if (this.ticks == 25) {
            this.conveyor.set(0.5);
            ++this.ticks;
        } else if (this.ticks < 25 && this.ticks > 0 || this.conveyor.indexerHasBall()) {
            ++this.ticks;
        }
    }

    @Override
    public boolean isFinished() {
        boolean hasBall = this.hasBall;
        this.hasBall = this.conveyor.conveyorHasBall();

        return !hasBall && this.hasBall;
    }
}
