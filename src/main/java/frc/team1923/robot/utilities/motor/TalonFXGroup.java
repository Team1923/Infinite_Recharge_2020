package frc.team1923.robot.utilities.motor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class TalonFXGroup extends MotorGroup {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    public Motor create() {
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

        leader.configOpenloopRamp(this.rampRate);
        leader.configClosedloopRamp(this.rampRate);

        leader.config_kP(0, this.p);
        leader.config_kI(0, this.i);
        leader.config_kD(0, this.d);
        leader.config_kF(0, this.f);

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
