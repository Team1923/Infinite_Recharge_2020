package frc.team1923.robot.utilities.motor;

public abstract class TunableMotorGroup<T extends TunableMotor> extends MotorGroup<T> {
    protected TunableMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    protected abstract T createTunable();

    @Override
    public T create() {
        T motor = this.createTunable();

        if (this.softLimit) {
            motor.setSoftLimits(this.reverseSoftLimit, this.forwardSoftLimit);
            motor.enableSoftLimits();
        }

        motor.setRamp(this.rampRate);

        motor.setP(this.p);
        motor.setI(this.i);
        motor.setD(this.d);
        motor.setF(this.f);

        return motor;
    }
}
