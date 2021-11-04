package frc.team1923.robot;

import java.security.KeyStore.PrivateKeyEntry;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import frc.team1923.robot.subsystems.ConveyorSubsystem;
import frc.team1923.robot.subsystems.DriveSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import jdk.dynalink.linker.ConversionComparator;

public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    // private DriveSubsystem drivetrain;
    // private ShooterSubsystem shooter;
    // private ConveyorSubsystem conveyor;
    // private IntakeSubsystem intake;
    private double startTime;

    @Override
    public void robotInit() {
        LiveWindow.disableAllTelemetry();

        this.robotContainer = new RobotContainer();
    }

    @Override
    public void autonomousInit() {

        robotContainer.intake.bringDown();

        robotContainer.drive.setSpeed(0.5, 0.5);




        // Command autonomousCommand = this.robotContainer.getAutonomousCommand();

        // if (autonomousCommand != null) {
        //     autonomousCommand.schedule();
        // }
    }


    public void autonomousPeriodic() {

        //Scheduler.getInstance().run();


        // double timer = Timer.getFPGATimestamp();

        // robotContainer.shooter.set(5500);

        // if(timer - startTime == 3){
        //     robotContainer.conveyor.set(4000);
        // }

       
            
     



    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {}

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}
}
