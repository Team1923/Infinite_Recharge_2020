package frc.team1923.robot.utilities.motor;

public abstract class TunableMotorGroup extends MotorGroup {
    protected TunableMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    public abstract TunableMotor createTunable();

    @Override
    public Motor create() {
        TunableMotor motor = this.createTunable();

        motor.setRamp(this.rampRate);

        motor.setP(this.p);
        motor.setI(this.i);
        motor.setD(this.d);
        motor.setF(this.f);

        return motor;
    }
}
