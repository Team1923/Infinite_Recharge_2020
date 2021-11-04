package frc.team1923.robot.utilities.controller;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.button.Button;

public class Controller {
    private final int port;

    public Controller(int port) {
        this.port = port;
    }

    protected Axis axis(int axis) {
        return new Axis(() -> DriverStation.getInstance().getStickAxis(this.port, axis));
    }

    protected Button button(int button) {
        return new Button(() -> DriverStation.getInstance().getStickButton(this.port, button));
    }

    protected DPad dPad(int pov) {
        return new DPad(
            this.povButton(pov, 225, 270, 315),
            this.povButton(pov, 315, 0, 45),
            this.povButton(pov, 45, 90, 135),
            this.povButton(pov, 135, 180, 225)
        );
    }

    private Button povButton(int pov, double... angles) {
        return new Button(() -> {
            double angle = DriverStation.getInstance().getStickPOV(this.port, pov);
            for (double i : angles) if (i == angle) return true;
            return false;
        });
    }

    private short leftRumble, rightRumble;

    public void setRumble(double left, double right) {
        short leftRumble = (short) Math.round(65535 * Math.max(0, Math.min(1, left)));
        short rightRumble = (short) Math.round(65535 * Math.max(0, Math.min(1, right)));

        if (this.leftRumble != leftRumble || this.rightRumble != rightRumble) {
            this.leftRumble = leftRumble;
            this.rightRumble = rightRumble;

            HAL.setJoystickOutputs((byte) this.port, 0, leftRumble, rightRumble);
        }
    }

    public void setRumble(double rumble) {
        this.setRumble(rumble, rumble);
    }
}
