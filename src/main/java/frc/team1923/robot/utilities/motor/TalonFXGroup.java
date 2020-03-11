package frc.team1923.robot.utilities.motor;

public class TalonFXGroup extends TunableMotorGroup<TalonFXMotor> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    public TalonFXMotor createTunable() {
        TalonFXMotor leader = new TalonFXMotor(this.leaderID, this.invert, !this.coast);

        if (this.softLimit) {
            leader.configForwardSoftLimitThreshold((int) Math.round(this.forwardSoftLimit * 2048));
            leader.configReverseSoftLimitThreshold((int) Math.round(this.reverseSoftLimit * 2048));

            leader.configForwardSoftLimitEnable(true);
            leader.configReverseSoftLimitEnable(true);
        }

        for (int followerID : this.followerIDs) {
            TalonFXMotor follower = new TalonFXMotor(followerID, this.invert, !this.coast);
            follower.follow(leader);
        }

        return leader;
    }
}
