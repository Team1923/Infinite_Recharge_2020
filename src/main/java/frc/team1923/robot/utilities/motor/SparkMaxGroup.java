package frc.team1923.robot.utilities.motor;

public class SparkMaxGroup extends TunableMotorGroup<SparkMaxMotor> {
    public SparkMaxGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    protected SparkMaxMotor createTunable() {
        SparkMaxMotor leader = new SparkMaxMotor(this.leaderID, this.invert, !this.coast);

        for (int followerID : this.followerIDs) {
            @SuppressWarnings("resource")
            SparkMaxMotor follower = new SparkMaxMotor(followerID, this.invert, !this.coast);
            follower.follow(leader);
        }

        return leader;
    }
}
