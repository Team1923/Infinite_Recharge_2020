package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparkMaxGroup extends MotorGroup<SparkMaxGroup> {
    public SparkMaxGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    public CANSparkMax create() {
        CANSparkMax leader = new CANSparkMax(this.leaderID, MotorType.kBrushless);
        leader.restoreFactoryDefaults();
        leader.setInverted(this.inverted);
        leader.setIdleMode(this.coast ? IdleMode.kCoast : IdleMode.kBrake);

        if (this.softLimit) {
            leader.setSoftLimit(SoftLimitDirection.kForward, (float) this.forwardSoftLimit);
            leader.setSoftLimit(SoftLimitDirection.kReverse, (float) this.reverseSoftLimit);

            leader.enableSoftLimit(SoftLimitDirection.kForward, true);
            leader.enableSoftLimit(SoftLimitDirection.kReverse, true);
        }

        for (int followerID : this.followerIDs) {
            @SuppressWarnings("resource")
            CANSparkMax follower = new CANSparkMax(followerID, MotorType.kBrushless);
            follower.restoreFactoryDefaults();
            follower.setIdleMode(this.coast ? IdleMode.kCoast : IdleMode.kBrake);
            follower.follow(leader);
        }

        return leader;
    }
}
