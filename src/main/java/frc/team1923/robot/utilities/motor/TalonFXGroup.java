package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TalonFXGroup extends MotorGroup<WPI_TalonFX> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
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
