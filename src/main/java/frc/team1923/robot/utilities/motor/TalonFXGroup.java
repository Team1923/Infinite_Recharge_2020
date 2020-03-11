package frc.team1923.robot.utilities.motor;

public class TalonFXGroup extends TunableMotorGroup<TalonFXMotor> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    protected TalonFXMotor createTunable() {
        TalonFXMotor leader = new TalonFXMotor(this.leaderID, this.invert, !this.coast);

        for (int followerID : this.followerIDs) {
            TalonFXMotor follower = new TalonFXMotor(followerID, this.invert, !this.coast);
            follower.follow(leader);
        }

        return leader;
    }
}
