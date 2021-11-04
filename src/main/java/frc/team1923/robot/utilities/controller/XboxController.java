package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

public class XboxController extends Controller {
    public final Joystick leftStick = new Joystick(
        this.axis(0).withDeadzone(0.1),
        this.axis(1).invert().withDeadzone(0.1)
    );
    public final Joystick rightStick = new Joystick(
        this.axis(4).withDeadzone(0.1),
        this.axis(5).invert().withDeadzone(0.1)
    );

    public final Axis leftTrigger = this.axis(2);
    public final Axis rightTrigger = this.axis(3);

    public final Button a = this.button(1);
    public final Button b = this.button(2);
    public final Button x = this.button(3);
    public final Button y = this.button(4);

    public final Button leftBumper = this.button(5);
    public final Button rightBumper = this.button(6);

    public final Button view = this.button(7);
    public final Button menu = this.button(8);

    public final Button leftClick = this.button(9);
    public final Button rightClick = this.button(10);

    public final DPad dPad = this.dPad(0);

    public XboxController(int port) {
        super(port);
    }
}
