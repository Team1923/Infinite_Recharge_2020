package frc.team1923.robot.utilities.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    private final NetworkTable table;

    private boolean enabled;
    private int pipeline;

    private double x, y;

    public Limelight(String table) {
        this.table = NetworkTableInstance.getDefault().getTable(table);
        this.disable();
    }

    public Limelight() {
        this("limelight");
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        this.table.getEntry("camMode").setDouble(enabled ? 0 : 1);
        this.table.getEntry("ledMode").setDouble(enabled ? 0 : 1);

        if (enabled) this.table.getEntry("pipeline").setDouble(this.pipeline);
    }

    public void enable() {
        this.setEnabled(true);
    }

    public void disable() {
        this.setEnabled(false);
    }

    public boolean hasValidTarget() {
        return this.enabled && this.table.getEntry("tv").getDouble(0) == 1;
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
        if (this.pipeline != pipeline) {
            this.pipeline = pipeline;

            if (this.enabled) this.table.getEntry("pipeline").setDouble(pipeline);
        }
    }
}
