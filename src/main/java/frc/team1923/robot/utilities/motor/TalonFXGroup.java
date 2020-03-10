package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class TalonFXGroup extends TunableMotorGroup {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    public TunableMotor createTunable() {
        TalonFX leader = new TalonFX(this.leaderID);

        leader.configFactoryDefault();
        leader.setInverted(this.invert);
        leader.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);

        if (this.softLimit) {
            leader.configForwardSoftLimitThreshold((int) Math.round(this.forwardSoftLimit * 2048));
            leader.configReverseSoftLimitThreshold((int) Math.round(this.reverseSoftLimit * 2048));

            leader.configForwardSoftLimitEnable(true);
            leader.configReverseSoftLimitEnable(true);
        }

        for (int followerID : this.followerIDs) {
            TalonFX follower = new TalonFX(followerID);

            follower.configFactoryDefault();
            follower.setInverted(this.invert);
            follower.setNeutralMode(this.coast ? NeutralMode.Coast : NeutralMode.Brake);
            follower.follow(leader);
        }

        return new TalonFXMotor(leader);
    }
}
