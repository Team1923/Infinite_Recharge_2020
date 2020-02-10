package frc.team1923.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.drivetrain.DriveArcadeCommand;
import frc.team1923.robot.commands.indexer.IndexerIndexCommand;
import frc.team1923.robot.commands.intake.IntakeIntakeCommand;
import frc.team1923.robot.commands.shooter.ShooterShootCommand;
import frc.team1923.robot.commands.turret.TurretRotateCommand;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;
import frc.team1923.robot.subsystems.ClimberSubsystem;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;
import frc.team1923.robot.subsystems.IndexerSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.ShooterSubsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

public class RobotContainer {
    public final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
    public final ShooterSubsystem shooter = new ShooterSubsystem();
    public final IntakeSubsystem intake = new IntakeSubsystem();
    public final IndexerSubsystem indexer = new IndexerSubsystem();
    public final TurretSubsystem turret = new TurretSubsystem();
    public final ControlPanelSubsystem controlPanel = null; //new ControlPanelSubsystem();
    public final ClimberSubsystem climber = null; //new ClimberSubsystem();

    public final PS4Controller driver = new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

    public RobotContainer() {
        new DriveArcadeCommand(this).setAsDefault();
        new IntakeIntakeCommand(this).setAsDefault();
        new IndexerIndexCommand(this).setAsDefault();
        new TurretRotateCommand(this).setAsDefault();

        this.operator.x.toggleWhenPressed(new ShooterShootCommand(this, 0.85));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
