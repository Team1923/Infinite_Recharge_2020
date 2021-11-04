package frc.team1923.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    @Override
    public void robotInit() {
        this.robotContainer = new RobotContainer();
    }

    @Override
    public void autonomousInit() {
        Command autonomousCommand = this.robotContainer.getAutonomousCommand();

        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
