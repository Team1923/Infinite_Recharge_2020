package frc.team1923.robot.utilities.motor;

public abstract class MotorGroup<This extends MotorGroup<This>> {
    protected final int leaderID;
    protected final int[] followerIDs;

    protected boolean inverted = false;
    protected boolean coast = false;

    protected boolean softLimit = false;
    protected double forwardSoftLimit = 0, reverseSoftLimit = 0;

    protected MotorGroup(int leaderID, int[] followerIDs) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
    }

    @SuppressWarnings("unchecked")
    private This getThis() {
        return (This) this;
    }

    public This inverting() {
        this.inverted = true;
        return this.getThis();
    }

    public This coasting() {
        this.coast = true;
        return this.getThis();
    }

    public This softLimiting(double forward, double reverse) {
        this.softLimit = true;
        this.forwardSoftLimit = forward;
        this.reverseSoftLimit = reverse;
        return this.getThis();
    }
}
