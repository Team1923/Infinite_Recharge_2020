package frc.team1923.robot.utilities.motor.group;

import frc.team1923.robot.utilities.motor.TalonFXMotor;

public class TalonFXGroup extends ConfigurableMotorGroup<TalonFXMotor> {
    public TalonFXGroup(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    @Override
    protected TalonFXMotor create(int deviceID) {
        return new TalonFXMotor(deviceID, this.invert, !this.coast);
    }
}
