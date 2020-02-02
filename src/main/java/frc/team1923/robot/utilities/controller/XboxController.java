package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

public class XboxController extends Controller {
    public final Joystick leftStick = new Joystick(0, 1, AxisRange.Normal, AxisRange.Inverted);
    public final Joystick rightStick = new Joystick(4, 5, AxisRange.Normal, AxisRange.Inverted);

    public final Axis leftTrigger = new Axis(2);
    public final Axis rightTrigger = new Axis(3);

    public final Button a = new ControllerButton(1);
    public final Button b = new ControllerButton(2);
    public final Button x = new ControllerButton(3);
    public final Button y = new ControllerButton(4);

    public final Button leftBumper = new ControllerButton(5);
    public final Button rightBumper = new ControllerButton(6);

    public final Button view = new ControllerButton(7);
    public final Button menu = new ControllerButton(8);

    public final Button leftClick = new ControllerButton(9);
    public final Button rightClick = new ControllerButton(10);

    public final DPad dPad = new DPad(0);

    public XboxController(int port) {
        super(port);
    }
}
