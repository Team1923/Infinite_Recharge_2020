package frc.team1923.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.climber.ClimberControlCommand;
import frc.team1923.robot.commands.controlPanel.ControlPanelControlCommand;
import frc.team1923.robot.commands.conveyor.ConveyorControlCommand;
import frc.team1923.robot.commands.conveyor.ConveyorSetCommand;
import frc.team1923.robot.commands.conveyor.ConveyorShiftCommand;
import frc.team1923.robot.commands.drivetrain.DriveArcadeCommand;
import frc.team1923.robot.commands.indexer.IndexerControlCommand;
import frc.team1923.robot.commands.indexer.IndexerCycleCommand;
import frc.team1923.robot.commands.intake.IntakeControlCommand;
import frc.team1923.robot.commands.intake.IntakeSetCommand;
import frc.team1923.robot.commands.shooter.ShooterShootCommand;
import frc.team1923.robot.commands.turret.TurretFollowCommand;
import frc.team1923.robot.commands.turret.TurretControlCommand;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;
import frc.team1923.robot.subsystems.ConveyorSubsystem;
import frc.team1923.robot.subsystems.ClimberSubsystem;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;
import frc.team1923.robot.subsystems.IndexerSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.Limelight;
import frc.team1923.robot.utilities.command.RepeatedCommand;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

public class RobotContainer {
    public final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
    public final ShooterSubsystem shooter = new ShooterSubsystem();
    public final IntakeSubsystem intake = new IntakeSubsystem();
    public final IndexerSubsystem indexer = new IndexerSubsystem();
    public final ConveyorSubsystem conveyor = new ConveyorSubsystem();
    public final TurretSubsystem turret = new TurretSubsystem();
    public final ControlPanelSubsystem controlPanel = new ControlPanelSubsystem();
    public final ClimberSubsystem climber = new ClimberSubsystem();

    public final Limelight limelight = new Limelight();

    public final PS4Controller driver = new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

    public RobotContainer() {
        new DriveArcadeCommand(this).setAsDefault();
        new IntakeControlCommand(this).setAsDefault();
        new IndexerControlCommand(this).setAsDefault();
        new ConveyorControlCommand(this).setAsDefault();
        new TurretControlCommand(this).setAsDefault();
        new ControlPanelControlCommand(this).setAsDefault();
        new ClimberControlCommand(this).setAsDefault();

        this.operator.x.toggleWhenPressed(new ShooterShootCommand(this));
        this.operator.leftBumper.whileHeld(new IndexerCycleCommand(this));
        this.operator.leftBumper.whenHeld(new IntakeSetCommand(this, 1));
        this.operator.dPad.up.whenHeld(new ConveyorSetCommand(this, 1));
        this.operator.a.toggleWhenPressed(new RepeatedCommand(new ConveyorShiftCommand(this)));
        this.operator.b.toggleWhenPressed(new TurretFollowCommand(this));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
