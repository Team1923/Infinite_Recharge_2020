package frc.team1923.robot.utilities.motor;

public interface FollowerMotor<T extends FollowerMotor<T>> extends Motor {
    void follow(T leader);
}
