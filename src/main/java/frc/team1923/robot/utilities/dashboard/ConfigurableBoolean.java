package frc.team1923.robot.utilities.dashboard;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ConfigurableBoolean {
    public ConfigurableBoolean(String name, Runnable callback) {
        NetworkTableEntry entry = SmartDashboard.getEntry(name);
        entry.addListener(entryNotification -> {
            if (entryNotification.value.getBoolean()) {
                entry.setBoolean(false);
                callback.run();
            }
        }, EntryListenerFlags.kUpdate);

        entry.setBoolean(true);
        entry.setBoolean(false);
    }
}
