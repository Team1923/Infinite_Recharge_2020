package frc.team1923.robot.utilities.motor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparkMaxGroup extends MotorGroup<CANSparkMax> {
    public SparkMaxGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
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
