package frc.team1923.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
