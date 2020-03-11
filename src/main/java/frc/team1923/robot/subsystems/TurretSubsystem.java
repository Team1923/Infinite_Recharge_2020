package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.team1923.robot.Constants.Turret;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.dashboard.ConfigurableBoolean;
import frc.team1923.robot.utilities.dashboard.ConfigurableDouble;
import frc.team1923.robot.utilities.motor.SparkMaxMotor;

public class TurretSubsystem extends SingleMotorSubsystem<SparkMaxMotor> {
    public TurretSubsystem() {
        super(Turret.TURRET);
    }

    private final DigitalInput isAtZeroSensor = new DigitalInput(Turret.IS_AT_ZERO_SENSOR);

    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public boolean isAtZero() {
        return this.isAtZeroSensor.get();
    }

    public double getHeading() {
        return this.gyro.getAngle();
    }

    public double getHeadingRate() {
        return this.gyro.getRate();
    }

    public void resetHeading() {
        this.gyro.reset();
    }

    {
        new ConfigurableBoolean("Reset Turret", () -> this.resetPosition(0));

        new ConfigurableDouble("Turret kP", kP -> this.getMotor().setP(kP), 0.04);
    }
}
