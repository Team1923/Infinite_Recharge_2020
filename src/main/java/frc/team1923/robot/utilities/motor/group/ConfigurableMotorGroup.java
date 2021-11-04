package frc.team1923.robot.utilities.motor.group;

import frc.team1923.robot.utilities.motor.ConfigurableMotor;

public abstract class ConfigurableMotorGroup<T extends ConfigurableMotor<T>> extends MotorGroup<T> {
    protected ConfigurableMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    protected abstract T create(int deviceID);

    @Override
    public T create() {
        T leader = this.create(this.leaderID);

        if (this.softLimit) {
            leader.setSoftLimits(this.reverseSoftLimit, this.forwardSoftLimit);
            leader.enableSoftLimits();
        }

        leader.setRamp(this.rampRate);

        leader.setP(this.p);
        leader.setI(this.i);
        leader.setD(this.d);
        leader.setF(this.f);

        for (int followerID : this.followerIDs) this.create(followerID).follow(leader);

        return leader;
    }
}
