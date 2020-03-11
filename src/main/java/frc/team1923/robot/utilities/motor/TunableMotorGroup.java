package frc.team1923.robot.utilities.motor;

public abstract class TunableMotorGroup<T extends TunableMotor & FollowerMotor<T>> extends FollowerMotorGroup<T> {
    protected TunableMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    public T create() {
        T motor = super.create();

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
