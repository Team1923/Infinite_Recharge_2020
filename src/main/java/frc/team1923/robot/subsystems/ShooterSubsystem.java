package frc.team1923.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1923.robot.Constants.Shooter;
import frc.team1923.robot.utilities.command.SingleMotorSubsystem;
import frc.team1923.robot.utilities.motor.TalonFXMotor;

public class ShooterSubsystem extends SingleMotorSubsystem<TalonFXMotor> {
    public ShooterSubsystem() {
        super(Shooter.SHOOTER);
    }

    private boolean spinningUp;
    private double targetVelocity;

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);

        this.spinningUp = false;
    }

    @Override
    public void stop() {
        super.stop();

        this.spinningUp = false;
    }

    @Override
    public void setPosition(double position) {
        super.setPosition(position);

        this.spinningUp = false;
    }

    @Override
    public void setVelocity(double velocity) {
        super.setVelocity(velocity);

        this.spinningUp = true;
        this.targetVelocity = velocity;
    }

    public boolean spunUp() {
        return this.spinningUp && this.getVelocity() > this.targetVelocity - 50;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Spun Up", this.spunUp());
    }
}
