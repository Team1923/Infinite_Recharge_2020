package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

public class PS4Controller extends Controller {
    public final Joystick leftStick = new Joystick(
        this.axis(0).withDeadzone(0.1),
        this.axis(1).invert().withDeadzone(0.1)
    );
    public final Joystick rightStick = new Joystick(
        this.axis(2).withDeadzone(0.1),
        this.axis(5).invert().withDeadzone(0.1)
    );

    public final Axis leftTrigger = this.axis(3).positive();
    public final Axis rightTrigger = this.axis(4).positive();

    public final Button square = this.button(1);
    public final Button cross = this.button(2);
    public final Button circle = this.button(3);
    public final Button triangle = this.button(4);

    public final Button leftBumper = this.button(5);
    public final Button rightBumper = this.button(6);

    public final Button share = this.button(9);
    public final Button options = this.button(10);

    public final Button leftClick = this.button(11);
    public final Button rightClick = this.button(12);

    public final Button ps = this.button(13);
    public final Button pad = this.button(14);

    public final DPad dPad = this.dPad(0);

    public PS4Controller(int port) {
        super(port);
    }
}
