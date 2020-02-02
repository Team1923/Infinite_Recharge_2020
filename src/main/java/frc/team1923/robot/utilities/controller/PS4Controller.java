package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

public class PS4Controller extends Controller {
    public final Joystick leftStick = new Joystick(0, 1, AxisRange.Normal, AxisRange.Inverted);
    public final Joystick rightStick = new Joystick(2, 5, AxisRange.Normal, AxisRange.Inverted);

    public final Axis leftTrigger = new Axis(3, AxisRange.Positive);
    public final Axis rightTrigger = new Axis(4, AxisRange.Positive);

    public final Button square = new ControllerButton(1);
    public final Button cross = new ControllerButton(2);
    public final Button circle = new ControllerButton(3);
    public final Button triangle = new ControllerButton(4);

    public final Button leftBumper = new ControllerButton(5);
    public final Button rightBumper = new ControllerButton(6);

    public final Button share = new ControllerButton(9);
    public final Button options = new ControllerButton(10);

    public final Button leftClick = new ControllerButton(11);
    public final Button rightClick = new ControllerButton(12);

    public final Button ps = new ControllerButton(13);
    public final Button pad = new ControllerButton(14);

    public final DPad dPad = new DPad(0);

    public PS4Controller(int port) {
        super(port);
    }
}
