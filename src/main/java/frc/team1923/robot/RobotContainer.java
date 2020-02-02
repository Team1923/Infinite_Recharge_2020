package frc.team1923.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.team1923.robot.Constants.Controllers;
import frc.team1923.robot.commands.controlPanel.ControlPanelControlCommand;
import frc.team1923.robot.commands.drivetrain.DriveControlCommand;
import frc.team1923.robot.commands.intake.IntakeIntakeCommand;
import frc.team1923.robot.commands.turret.TurretShootCommand;
import frc.team1923.robot.subsystems.ControlPanelSubsystem;
import frc.team1923.robot.subsystems.DrivetrainSubsystem;
import frc.team1923.robot.subsystems.IntakeSubsystem;
import frc.team1923.robot.subsystems.Subsystem;
import frc.team1923.robot.subsystems.TurretSubsystem;
import frc.team1923.robot.utilities.controller.PS4Controller;
import frc.team1923.robot.utilities.controller.XboxController;

import java.util.Set;

public class RobotContainer {
    public final Set<Subsystem> subsystems = Set.of(
        new DrivetrainSubsystem(),
        new TurretSubsystem(),
        new IntakeSubsystem(),
        new ControlPanelSubsystem()
    );

    public final PS4Controller driver = new PS4Controller(Controllers.DRIVER);
    public final XboxController operator = new XboxController(Controllers.OPERATOR);

	public final Command autonomousCommand = null;

    public RobotContainer() {
        new DriveControlCommand(this).setAsDefault();
        new ControlPanelControlCommand(this).setAsDefault();

        this.operator.x.toggleWhenPressed(new TurretShootCommand(this, 0.5));
        this.operator.a.whenHeld(new IntakeIntakeCommand(this, 0.75));
        this.operator.b.whenHeld(new IntakeIntakeCommand(this, -0.75));
    }
}
