package frc.team1923.robot.utilities;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    private NetworkTable table;
    private double x, y, area;

    public Limelight(String table) {
        this.table = NetworkTableInstance.getDefault().getTable(table);
    }

    public Limelight() {
        this("limelight");
    }

    public boolean isValidTarget() {
        return this.table.getEntry("tv").getNumber(0).intValue() == 1;
    }

    public double getX() {
        if (this.isValidTarget()) {
            this.x = this.table.getEntry("tx").getDouble(0);
        }

        return this.x;
    }

    public double getY() {
        if (this.isValidTarget()) {
            this.y = this.table.getEntry("ty").getDouble(0);
        }

        return this.y;
    }

    public double getArea() {
        if (this.isValidTarget()) {
            this.area = this.table.getEntry("ta").getDouble(0);
        }

        return this.area;
    }

    public void setPipeline(int pipeline) {
        this.table.getEntry("pipeline").setDouble(pipeline);
    }
}
