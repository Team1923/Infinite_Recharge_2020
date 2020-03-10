package frc.team1923.robot.utilities.motor;

public interface TunableMotor extends Motor {
    void setRamp(double rate);

    void setP(double p);
    void setI(double i);
    void setD(double d);
    void setF(double f);
}
