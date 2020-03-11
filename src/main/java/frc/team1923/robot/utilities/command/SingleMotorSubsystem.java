package frc.team1923.robot.utilities.command;

import frc.team1923.robot.utilities.controller.Axis;
import frc.team1923.robot.utilities.motor.Motor;
import frc.team1923.robot.utilities.motor.OptimizedMotor;
import frc.team1923.robot.utilities.motor.group.MotorGroup;

public class SingleMotorSubsystem<T extends Motor> extends MotorSubsystem {
    private final T rawMotor;
    private final OptimizedMotor motor;

    private static Motor tempRawMotor;
    private static OptimizedMotor tempMotor;

    private static Motor wrapGroup(MotorGroup<?> motorGroup) {
        SingleMotorSubsystem.tempRawMotor = motorGroup.create();
        SingleMotorSubsystem.tempMotor = new OptimizedMotor(SingleMotorSubsystem.tempRawMotor);
        return SingleMotorSubsystem.tempMotor;
    }

    public SingleMotorSubsystem(MotorGroup<T> motorGroup) {
        super(SingleMotorSubsystem.wrapGroup(motorGroup));

        @SuppressWarnings("unchecked")
        T rawMotor = (T) SingleMotorSubsystem.tempRawMotor;

        this.rawMotor = rawMotor;
        this.motor = SingleMotorSubsystem.tempMotor;

        SingleMotorSubsystem.tempRawMotor = null;
        SingleMotorSubsystem.tempMotor = null;
    }

    protected T getMotor() {
        return this.rawMotor;
    }

    public void setSpeed(double speed) {
        this.motor.setSpeed(speed);
    }

    public void stop() {
        this.motor.stop();
    }

    public double getPosition() {
        return this.motor.getPosition();
    }

    public void resetPosition(double position) {
        this.motor.resetPosition(position);
    }

    public void setPosition(double position) {
        this.motor.setPosition(position);
    }

    public double getVelocity() {
        return this.motor.getVelocity();
    }

    public void setVelocity(double velocity) {
        this.motor.setVelocity(velocity);
    }

    public Command<?> set(double speed) {
        return new Command<SingleMotorSubsystem<T>>(this) {
            @Override
            public void initialize() {
                this.subsystem.setSpeed(speed);
            }
        };
    }

    public Command<?> control(Axis axis) {
        return new Command<SingleMotorSubsystem<T>>(this) {
            @Override
            public void execute() {
                this.subsystem.setSpeed(axis.get());
            }
        };
    }
}
