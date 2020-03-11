package frc.team1923.robot.utilities.motor;

public class TalonFXGroup extends TunableMotorGroup<TalonFXMotor> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    protected TalonFXMotor create(int deviceID) {
        return new TalonFXMotor(deviceID, this.invert, !this.coast);
    }
}
