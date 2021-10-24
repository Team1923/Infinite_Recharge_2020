package frc.team1923.robot;

import java.security.KeyStore.Entry;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.conveyor.ConveyorControlCommand;
import frc.team1923.robot.commands.conveyor.ConveyorShiftCommand;
import frc.team1923.robot.commands.drivetrain.DriveArcadeCommand;
import frc.team1923.robot.commands.indexer.IndexerCycleCommand;
import frc.team1923.robot.commands.indexer.IndexerIndexCommand;
import frc.team1923.robot.commands.intake.IntakeIntakeCommand;
import frc.team1923.robot.commands.shooter.ShooterShootCommand;
import frc.team1923.robot.commands.shooter.ShooterTargetCommand;
import frc.team1923.robot.commands.turret.TurretCommand;
import frc.team1923.robot.commands.turret.TurretFollowCommand;
import frc.team1923.robot.commands.turret.TurretRotateCommand;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;
import frc.team1923.robot.subsystems.ConveyorSubsystem;
import frc.team1923.robot.subsystems.ClimberSubsystem;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;
import frc.team1923.robot.subsystems.IndexerSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.ConfigurableDouble;
import frc.team1923.robot.utilities.Limelight;
import frc.team1923.robot.utilities.command.RepeatedCommand;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

public class RobotContainer {
    public final DrivetrainSubsystem drivetrain = null;//new DrivetrainSubsystem();
    public final ShooterSubsystem shooter = new ShooterSubsystem();
    public final IntakeSubsystem intake = new IntakeSubsystem();
    public final IndexerSubsystem indexer = new IndexerSubsystem();
    public final ConveyorSubsystem conveyor = new ConveyorSubsystem();
    public final TurretSubsystem turret = new TurretSubsystem();
    public final ControlPanelSubsystem controlPanel = null; //new ControlPanelSubsystem();
    public final ClimberSubsystem climber = null; //new ClimberSubsystem();

    public final Limelight limelight = new Limelight();

    public final PS4Controller driver = null;//new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

    public RobotContainer() {
        new DriveArcadeCommand(this).setAsDefault();
        new IntakeIntakeCommand(this).setAsDefault();
        new IndexerIndexCommand(this).setAsDefault();
        new ConveyorControlCommand(this).setAsDefault();
        new TurretRotateCommand(this).setAsDefault();


        /*
        this.operator.dPad.up.whenPressed(new InstantCommand(() -> this.turret.resetPosition(0)));
        this.operator.dPad.left.whenHeld(new TurretCommand(this) {
            @Override
            public void initialize() {
                this.turret.setPosition(90);
            }
        });
        this.operator.dPad.right.whenHeld(new TurretCommand(this) {
            @Override
            public void initialize() {
                this.turret.setPosition(-90);
            }
        });
        */

        this.operator.b.toggleWhenPressed(new TurretFollowCommand(this));

        this.operator.a.toggleWhenPressed(new RepeatedCommand(new ConveyorShiftCommand(this)));
        this.operator.dPad.down.whenPressed(new IndexerCycleCommand(this));

        this.operator.x.toggleWhenPressed(new ShooterShootCommand(this, 5000));

        this.operator.y.toggleWhenPressed(new ShooterTargetCommand(this));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
