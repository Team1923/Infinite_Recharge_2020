package frc.team1923.robot.utilities.motor;

public class SparkMaxGroup extends TunableMotorGroup<SparkMaxMotor> {
    public SparkMaxGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    protected SparkMaxMotor create(int deviceID) {
        return new SparkMaxMotor(deviceID, this.invert, !this.coast);
    }
}
