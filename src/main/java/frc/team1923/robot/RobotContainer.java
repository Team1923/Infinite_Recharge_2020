package frc.team1923.robot;

import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.controlPanel.ControlPanelControlCommand;
import frc.team1923.robot.commands.drivetrain.DriveControlCommand;
import frc.team1923.robot.commands.intake.IntakeIntakeCommand;
import frc.team1923.robot.commands.turret.TurretShootCommand;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

public class RobotContainer {
    public final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
    public final TurretSubsystem turret = new TurretSubsystem();
    public final IntakeSubsystem intake = new IntakeSubsystem();
    public final ControlPanelSubsystem controlPanel = new ControlPanelSubsystem();

    public final PS4Controller driver = new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

    public RobotContainer() {
        this.drivetrain.setDefaultCommand(new DriveControlCommand(this));
        this.controlPanel.setDefaultCommand(new ControlPanelControlCommand(this));

        this.operator.x.toggleWhenPressed(new TurretShootCommand(this, 0.5));
        this.operator.a.whenHeld(new IntakeIntakeCommand(this, 0.75));
        this.operator.b.whenHeld(new IntakeIntakeCommand(this, -0.75));
    }
}
