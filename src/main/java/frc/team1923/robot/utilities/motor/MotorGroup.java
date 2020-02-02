package frc.team1923.robot.utilities.motor;

public abstract class MotorGroup<T> {
    protected final int leaderID;
    protected final int[] followerIDs;

    protected boolean inverted = false;
    protected boolean coast = false;

    protected MotorGroup(int leaderID, int[] followerIDs) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
    }

    public MotorGroup<T> inverting() {
        this.inverted = true;
        return this; 
    }

    public MotorGroup<T> coasting() {
        this.coast = true;
        return this;
    }

    public abstract T create();
}
