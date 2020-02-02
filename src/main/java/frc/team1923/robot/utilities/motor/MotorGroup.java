package frc.team1923.robot.utilities.motor;

public abstract class MotorGroup<Self extends MotorGroup<Self, Motor>, Motor> {
    protected final int leaderID;
    protected final int[] followerIDs;

    protected boolean inverted = false;
    protected boolean coast = false;

    protected MotorGroup(int leaderID, int[] followerIDs) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
    }

    protected abstract Self getThis();

    public Self inverting() {
        this.inverted = true;
        return this.getThis();
    }

    public Self coasting() {
        this.coast = true;
        return this.getThis();
    }

    public abstract Motor create();
}
