package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TalonFXGroup extends MotorGroup<TalonFXGroup> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    public WPI_TalonFX create() {
        TalonFXConfiguration leaderConfig = new TalonFXConfiguration();

        if (this.softLimit) {
            leaderConfig.forwardSoftLimitThreshold = (int) Math.round(this.forwardSoftLimit * 2048);
            leaderConfig.reverseSoftLimitThreshold = (int) Math.round(this.forwardSoftLimit * 2048);

            leaderConfig.forwardSoftLimitEnable = true;
            leaderConfig.reverseSoftLimitEnable = true;
        }

        WPI_TalonFX leader = new WPI_TalonFX(this.leaderID);
        leader.configAllSettings(leaderConfig);
        leader.setInverted(this.inverted);
        leader.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);

        TalonFXConfiguration followerConfig = new TalonFXConfiguration();

        for (int followerID : this.followerIDs) {
            WPI_TalonFX follower = new WPI_TalonFX(followerID);
            follower.configAllSettings(followerConfig);
            follower.setInverted(this.inverted);
            follower.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);
            follower.follow(leader);
        }

        return leader;
    }
}
