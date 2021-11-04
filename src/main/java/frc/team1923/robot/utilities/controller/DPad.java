package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

public class DPad {
    public final Button left, up, right, down;

    public DPad(Button left, Button up, Button right, Button down) {
        this.left = left;
        this.up = up;
        this.right = right;
        this.down = down;
    }
}
