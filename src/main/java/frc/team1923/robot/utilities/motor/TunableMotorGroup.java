package frc.team1923.robot.utilities.motor;

public abstract class TunableMotorGroup<T extends TunableMotor> extends MotorGroup<T> {
    protected TunableMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    public abstract T createTunable();

    @Override
    public T create() {
        T motor = this.createTunable();

        motor.setRamp(this.rampRate);

        motor.setP(this.p);
        motor.setI(this.i);
        motor.setD(this.d);
        motor.setF(this.f);

        return motor;
    }
}
