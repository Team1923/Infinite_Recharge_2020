package frc.team1923.robot.utilities.motor;

public abstract class MotorGroup<This extends MotorGroup<This>> {
    protected final int leaderID;
    protected final int[] followerIDs;

    protected boolean inverted, coast;

    protected boolean softLimit;
    protected double forwardSoftLimit, reverseSoftLimit;

    protected double rampRate;

    protected double p, i, d, f;

    protected MotorGroup(int leaderID, int... followerIDs) {
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

    public This ramping(double rate) {
        this.rampRate = rate;

        return this.getThis();
    }

    public This withPIDF(double p, double i, double d, double f) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.f = f;

        return this.getThis();
    }
}
