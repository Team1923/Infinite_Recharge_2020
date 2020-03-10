package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team1923.robot.Constants.Turret;
import frc.team1923.robot.utilities.command.Subsystem;

public class TurretSubsystem extends Subsystem {
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
        SmartDashboard.putBoolean("Reset Turret", true);
        SmartDashboard.putBoolean("Reset Turret", false);
    }

    @Override
    public void periodic() {
        if (SmartDashboard.getBoolean("Reset Turret", false)) {
            SmartDashboard.putBoolean("Reset Turret", false);

            this.resetPosition(0);
        }
    }
}
