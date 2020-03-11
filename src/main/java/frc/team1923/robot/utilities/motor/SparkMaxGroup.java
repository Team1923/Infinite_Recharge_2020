package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANSparkMax.SoftLimitDirection;

public class SparkMaxGroup extends TunableMotorGroup<SparkMaxMotor> {
    public SparkMaxGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    public SparkMaxMotor createTunable() {
        SparkMaxMotor leader = new SparkMaxMotor(this.leaderID, this.invert, !this.coast);

        if (this.softLimit) {
            leader.setSoftLimit(SoftLimitDirection.kForward, (float) this.forwardSoftLimit);
            leader.setSoftLimit(SoftLimitDirection.kReverse, (float) this.reverseSoftLimit);

            leader.enableSoftLimit(SoftLimitDirection.kForward, true);
            leader.enableSoftLimit(SoftLimitDirection.kReverse, true);
        }

        for (int followerID : this.followerIDs) {
            @SuppressWarnings("resource")
            SparkMaxMotor follower = new SparkMaxMotor(followerID, this.invert, !this.coast);
            follower.follow(leader);
        }

        return leader;
    }
}
