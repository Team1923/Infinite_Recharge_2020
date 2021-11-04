package frc.team1923.robot.utilities.motor;

public interface ConfigurableMotor<T extends ConfigurableMotor<T>> extends Motor {
    void setSoftLimits(double reverse, double forward);
    void enableSoftLimits(boolean enable);

    default void enableSoftLimits() {
        this.enableSoftLimits(true);
    }

    default void disableSoftLimits() {
        this.enableSoftLimits(false);
    }

    void setRamp(double rate);

    void setP(double p);
    void setI(double i);
    void setD(double d);
    void setF(double f);

    void follow(T leader);
}
