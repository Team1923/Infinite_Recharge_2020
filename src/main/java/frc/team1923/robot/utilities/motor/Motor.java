package frc.team1923.robot.utilities.motor;

public interface Motor {
    void setSpeed(double speed);

    default void stop() {
        this.setSpeed(0);
    }

    double getPosition();
    void resetPosition(double position);
    void setPosition(double position);

    double getVelocity();
    void setVelocity(double velocity);
}
