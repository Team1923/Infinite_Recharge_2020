package frc.team1923.robot.utilities.controller;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.button.Button;

import java.util.Arrays;

public abstract class Controller {
    private final int port;

    protected enum AxisRange {
        Normal, Inverted, Positive
    }

    public class Axis {
        private final int axis;
        private final AxisRange range;
        private final double deadzone;

        protected Axis(int axis, AxisRange range, double deadzone) {
            this.axis = axis;
            this.range = range;
            this.deadzone = deadzone;
        }

        protected Axis(int axis, AxisRange range) {
            this(axis, range, 0);
        }

        protected Axis(int axis, double deadzone) {
            this(axis, AxisRange.Normal, deadzone);
        }

        protected Axis(int axis) {
            this(axis, AxisRange.Normal, 0);
        }

        public double get() {
            double raw = DriverStation.getInstance().getStickAxis(Controller.this.port, this.axis);

            switch (this.range) {
                case Inverted:
                    raw = -raw;
                    break;
                case Positive:
                    raw = 0.5 * raw + 0.5;
                    break;
                default:
            }

            return Math.copySign(Math.max(0, (Math.abs(raw) - this.deadzone) / (1 - this.deadzone)), raw);
        }

        public Button withLowerTreshold(double lower) {
            return new Button(() -> this.get() >= lower);
        }

        public Button withUpperTreshold(double upper) {
            return new Button(() -> this.get() <= upper);
        }
    }

    public class Joystick {
        public final Axis x, y;

        protected Joystick(int xAxis, int yAxis, AxisRange xRange, AxisRange yRange, double deadzone) {
            this.x = new Axis(xAxis, xRange, deadzone);
            this.y = new Axis(yAxis, yRange, deadzone);
        }

        protected Joystick(int xAxis, int yAxis, AxisRange xRange, AxisRange yRange) {
            this.x = new Axis(xAxis, xRange);
            this.y = new Axis(yAxis, yRange);
        }

        protected Joystick(int xAxis, int yAxis, double deadzone) {
            this.x = new Axis(xAxis, deadzone);
            this.y = new Axis(yAxis, deadzone);
        }

        protected Joystick(int xAxis, int yAxis) {
            this.x = new Axis(xAxis);
            this.y = new Axis(yAxis);
        }
    }

    protected class ControllerButton extends Button {
        private final int button;

        protected ControllerButton(int button) {
            this.button = button;
        }

        @Override
        public boolean get() {
            return DriverStation.getInstance().getStickButton(Controller.this.port, this.button);
        }
    }

    public class DPad {
        private final int pov;

        private class DPadButton extends Button {
            private final double[] angles;

            private DPadButton(double... angles) {
                this.angles = angles;
            }

            @Override
            public boolean get() {
                double angle = DriverStation.getInstance().getStickPOV(Controller.this.port, DPad.this.pov);
                return Arrays.stream(this.angles).anyMatch(i -> i == angle);
            }
        }

        public final Button left = new DPadButton(225, 270, 315);
        public final Button up = new DPadButton(315, 0, 45);
        public final Button right = new DPadButton(45, 90, 135);
        public final Button down = new DPadButton(135, 180, 225);

        protected DPad(int pov) {
            this.pov = pov;
        }
    }

    protected Controller(int port) {
        this.port = port;
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
