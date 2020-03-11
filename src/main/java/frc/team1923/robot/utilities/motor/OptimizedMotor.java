package frc.team1923.robot.utilities.motor;

public class OptimizedMotor<T extends Motor> implements Motor {
    private enum Mode {
        Speed, Position, Velocity
    }

    private final T motor;
    private Mode mode = Mode.Speed;
    private double value;

    public OptimizedMotor(T motor) {
        this.motor = motor;
    }

    private boolean set(Mode mode, double value) {
        if (this.mode != mode || this.value != value) {
            this.mode = mode;
            this.value = value;
            return true;
        }
        return false;
    }

    @Override
    public void setSpeed(double speed) {
        if (this.set(Mode.Speed, speed)) this.motor.setSpeed(speed);
    }

    @Override
    public double getPosition() {
        return this.motor.getPosition();
    }

    @Override
    public void resetPosition(double position) {
        this.motor.resetPosition(position);
    }

    @Override
    public void setPosition(double position) {
        if (this.set(Mode.Position, position)) this.motor.setPosition(position);
    }

    @Override
    public double getVelocity() {
        return this.motor.getVelocity();
    }

    @Override
    public void setVelocity(double velocity) {
        if (this.set(Mode.Velocity, velocity)) this.motor.setVelocity(velocity);
    }
}
