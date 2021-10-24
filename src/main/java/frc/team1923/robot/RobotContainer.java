package frc.team1923.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.AutoIndexCommand;
import frc.team1923.robot.commands.drive.DriveArcadeCommand;
import frc.team1923.robot.commands.intake.IntakeCycleCommand;
import frc.team1923.robot.commands.intake.IntakeIntakeCommand;
import frc.team1923.robot.commands.shooter.ShooterShootCommand;
import frc.team1923.robot.commands.turret.TurretFollowCommand;
import frc.team1923.robot.subsystems.ClimberSubsystem;
import frc.team1923.robot.subsystems.ConveyorSubsystem;
import frc.team1923.robot.subsystems.DriveSubsystem;
import frc.team1923.robot.subsystems.IndexerSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.command.RepeatedCommand;
import frc.team1923.robot.utilities.controller.Axis;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;
import frc.team1923.robot.utilities.dashboard.ConfigurableDouble;

public class RobotContainer {
    public final DriveSubsystem drive = new DriveSubsystem();
    public final ShooterSubsystem shooter = new ShooterSubsystem();
    public final IntakeSubsystem intake = new IntakeSubsystem();
    public final IndexerSubsystem indexer = new IndexerSubsystem();
    public final ConveyorSubsystem conveyor = new ConveyorSubsystem();
    public final TurretSubsystem turret = new TurretSubsystem();
    public final ClimberSubsystem climber = new ClimberSubsystem();

    public final TurretLimelight limelight = new TurretLimelight();

    public final PS4Controller driver = new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

    private boolean run;
    private double timeSinceLastBall;
    private double speedValue = 0.8;

    public RobotContainer() {
        new DriveArcadeCommand(this.drive, this.driver.leftStick.y.squared(), this.driver.rightStick.x.squared()).setAsDefault();
        this.intake.control(this.operator.leftStick.y).setAsDefault();
        this.conveyor.control(this.operator.rightStick.y).setAsDefault();
        this.turret.control(this.operator.leftTrigger.subtract(this.operator.rightTrigger)).setAsDefault(); // or gohomecommand.andthen control

        AutoIndexCommand cmd = new AutoIndexCommand(this);
        this.operator.a.toggleWhenPressed(
            new RepeatedCommand(cmd)
            .withInterrupt(() -> cmd.balls == 5)
            .deadlineWith(new IntakeIntakeCommand(this.intake, this.operator.leftStick.y, new IntakeCycleCommand(this.intake).repeatedly()))
        );
        Command[] b = {
            new ShooterShootCommand(this.shooter),
            new FunctionalCommand(() -> {}, () -> {}, interrupted -> cmd.balls = 0, () -> false),
            new TurretFollowCommand(this.turret, this.limelight)
        };

        for (Command c : b) {
            this.operator.b.toggleWhenPressed(c);
        }

        this.operator.x.toggleWhenPressed((new WaitUntilCommand(() -> this.shooter.spunUp() && this.limelight.hasValidTarget()).raceWith(new WaitCommand(2))).andThen(() -> this.timeSinceLastBall = Timer.getFPGATimestamp()).andThen(this.conveyor.set(this.speedValue).withInterrupt(() -> {
            if (this.conveyor.turretHasBall()) this.timeSinceLastBall = Timer.getFPGATimestamp();
            return Timer.getFPGATimestamp() - this.timeSinceLastBall > 0.75;
        })).andThen(() -> {
            for (Command c : b) {
                if (c.isScheduled()) {
                    c.cancel();
                }
            }
        }));

        this.operator.menu.whenPressed(() -> this.intake.bringDown(), this.intake);
        this.operator.view.whenPressed(() -> this.intake.bringUp(), this.intake);

        this.driver.dPad.left.whenPressed(() -> this.climber.bringDown(), this.climber);
        this.driver.dPad.right.whenPressed(() -> this.climber.bringUp(), this.climber);

        //this.climber.control(Axis.fromButton(this.driver.dPad.up).subtract(Axis.fromButton(this.driver.dPad.down))).setAsDefault();

        this.driver.dPad.up.whenHeld(this.climber.set(1));
        this.driver.dPad.up.whenHeld(this.climber.set(-1));

        this.operator.y.toggleWhenPressed(new ShooterShootCommand(this.shooter));

        new ConfigurableDouble("Feed Speed", sp -> this.speedValue = sp, 1);

        this.operator.dPad.down.whenPressed(() -> this.limelight.enable());
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
