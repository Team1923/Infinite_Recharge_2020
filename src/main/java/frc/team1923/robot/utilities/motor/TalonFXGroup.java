package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TalonFXGroup {
    private final int leaderID;
    private final int[] followerIDs;

    private final boolean inverted;
    private final boolean coast;

    private TalonFXGroup(int leaderID, int[] followerIDs, boolean inverted, boolean coast) {
        this.leaderID = leaderID;
        this.followerIDs = followerIDs;
        this.inverted = inverted;
        this.coast = coast;
    }

    public TalonFXGroup(int leaderID, int... followerIDs) {
        this(leaderID, followerIDs, false, false);
    }

    public TalonFXGroup inverting() {
        return new TalonFXGroup(this.leaderID, this.followerIDs, true, this.coast);
    }

    public TalonFXGroup coasting() {
        return new TalonFXGroup(this.leaderID, this.followerIDs, this.inverted, true);
    }

    public WPI_TalonFX create() {
        WPI_TalonFX leader = new WPI_TalonFX(this.leaderID);
        leader.configFactoryDefault();
        leader.setInverted(this.inverted);
        leader.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);

        for (int followerID : this.followerIDs) {
            WPI_TalonFX follower = new WPI_TalonFX(followerID);
            follower.configFactoryDefault();
            follower.setInverted(this.inverted);
            follower.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);
            follower.follow(leader);
        }

        return leader;
    }
}
