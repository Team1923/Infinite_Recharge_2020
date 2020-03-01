package frc.team1923.robot.utilities;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    private final NetworkTable table;
    private double x, y;

    public Limelight(String table) {
        this.table = NetworkTableInstance.getDefault().getTable(table);
    }

    public Limelight() {
        this("limelight");
    }

    public boolean hasValidTarget() {
        return this.table.getEntry("tv").getDouble(0) == 1;
    }

    public double getX() {
        if (this.hasValidTarget()) {
            this.x = this.table.getEntry("tx").getDouble(this.x);
        }

        return this.x;
    }

    public double getY() {
        if (this.hasValidTarget()) {
            this.y = this.table.getEntry("ty").getDouble(this.y);
        }

        return this.y;
    }

    public void setPipeline(int pipeline) {
        this.table.getEntry("pipeline").setDouble(pipeline);
    }

    public void setCameraMode(boolean driverCamera) {
        this.table.getEntry("camMode").setDouble(driverCamera ? 1 : 0);
    }
}
