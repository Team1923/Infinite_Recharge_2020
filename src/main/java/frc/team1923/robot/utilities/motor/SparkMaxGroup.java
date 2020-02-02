package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparkMaxGroup {
    private final int leaderID;
    private final int[] followerIDs;

    private final boolean inverted;
    private final boolean coast;

    private SparkMaxGroup(int leaderID, int[] followerIDs, boolean inverted, boolean coast) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
        this.inverted = inverted;
        this.coast = coast;
    }

    public SparkMaxGroup(int leaderID, int... followerIDs) {
        this(leaderID, followerIDs, false, false);
    }

    public SparkMaxGroup inverting() {
        return new SparkMaxGroup(this.leaderID, this.followerIDs, true, this.coast);
    }

    public SparkMaxGroup coasting() {
        return new SparkMaxGroup(this.leaderID, this.followerIDs, this.inverted, true);
    }

    public CANSparkMax create() {
        CANSparkMax leader = new CANSparkMax(this.leaderID, MotorType.kBrushless);
        leader.restoreFactoryDefaults();
        leader.setInverted(this.inverted);
        leader.setIdleMode(this.coast ? IdleMode.kCoast : IdleMode.kBrake);

        for (int followerID : this.followerIDs) {
            CANSparkMax follower = new CANSparkMax(followerID, MotorType.kBrushless);
            follower.restoreFactoryDefaults();
            follower.setIdleMode(this.coast ? IdleMode.kCoast : IdleMode.kBrake);
            follower.follow(leader);
        }

        return leader;
    }
}
