package frc.team1923.robot.utilities.motor;

public abstract class FollowerMotorGroup<T extends FollowerMotor<T>> extends MotorGroup<T> {
    protected FollowerMotorGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    protected abstract T create(int deviceID);

    @Override
    public T create() {
        T leader = this.create(this.leaderID);

        for (int followerID : this.followerIDs) this.create(followerID).follow(leader);

        return leader;
    }
}
