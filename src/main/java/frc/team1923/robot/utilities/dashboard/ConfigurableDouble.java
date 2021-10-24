package frc.team1923.robot.utilities.dashboard;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.DoubleConsumer;

public class ConfigurableDouble {
    public ConfigurableDouble(String name, DoubleConsumer callback, double defaultValue) {
        NetworkTableEntry entry = SmartDashboard.getEntry(name);
        entry.addListener(entryNotification -> callback.accept(entryNotification.value.getDouble()), EntryListenerFlags.kUpdate);

        defaultValue = entry.getDouble(defaultValue);
        entry.setDouble(-1337);
        entry.setDouble(defaultValue);
        callback.accept(defaultValue);
    }

    public ConfigurableDouble(String name, DoubleConsumer callback) {
        this(name, callback, 0);
    }
}
