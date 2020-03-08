package frc.team1923.robot.utilities.controller;

import edu.wpi.first.wpilibj2.command.button.Button;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

public class Axis {
    private final DoubleSupplier value;

    public Axis(DoubleSupplier value) {
        this.value = value;
    }

    public Axis() {
        this(() -> 0);
    }

    public double get() {
        return this.value.getAsDouble();
    }

    public Button withLowerTreshold(double lower) {
        return new Button(() -> this.get() >= lower);
    }

    public Button withUpperTreshold(double upper) {
        return new Button(() -> this.get() <= upper);
    }

    public static Axis fromButton(Button button, double falseValue, double trueValue) {
        return new Axis(() -> button.get() ? trueValue : falseValue);
    }

    public static Axis fromButton(Button button) {
        return Axis.fromButton(button, 0, 1);
    }

    public Axis withDeadzone(double deadzone) {
        return new Axis(() -> {
            double value = this.get();
            return Math.copySign(Math.max(0, (Math.abs(value) - deadzone) / (1 - deadzone)), value);
        });
    }

    public Axis invert() {
        return new Axis(() -> -this.get());
    }

    public Axis positive() {
        return new Axis(() -> this.get() * 0.5 + 0.5);
    }

    public Axis squared() {
        return new Axis(() -> {
            double value = this.get();
            return value * Math.abs(value);
        });
    }

    public Axis clamp() {
        return new Axis(() -> Math.min(Math.max(this.get(), -1), 1));
    }

    public Axis map(DoubleUnaryOperator function) {
        return new Axis(() -> function.applyAsDouble(this.get()));
    }

    public Axis add(Axis axis) {
        return new Axis(() -> this.get() + axis.get());
    }

    public Axis subtract(Axis axis) {
        return new Axis(() -> this.get() - axis.get());
    }

    public Axis combineWith(DoubleBinaryOperator function, Axis axis) {
        return new Axis(() -> function.applyAsDouble(this.get(), axis.get()));
    }
}
