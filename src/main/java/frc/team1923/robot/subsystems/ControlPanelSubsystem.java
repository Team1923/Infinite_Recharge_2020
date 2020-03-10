package frc.team1923.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import frc.team1923.robot.Constants.ControlPanel;
import frc.team1923.robot.utilities.command.Subsystem;

public class ControlPanelSubsystem extends Subsystem {
    private final ColorSensorV3 colorSensor = new ColorSensorV3(Port.kOnboard);
    private final ColorMatch colorMatch = new ColorMatch();

    public enum WheelColor {
        Red(0.52, 0.35, 0.13),
        Green(0.17, 0.58, 0.25),
        Blue(0.12, 0.43, 0.45),
        Yellow(0.31, 0.56, 0.12);

        public final Color color;

        private WheelColor(double red, double green, double blue) {
            this.color = new Color(red, green, blue);
        }
    }

    public ControlPanelSubsystem() {
        super(ControlPanel.SPINNER);

        for (WheelColor wheelColor : WheelColor.values()) {
            colorMatch.addColorMatch(wheelColor.color);
        }
    }

    public WheelColor getColor() {
        Color color = this.colorSensor.getColor();

        SmartDashboard.putNumber("red", color.red);
        SmartDashboard.putNumber("green", color.green);
        SmartDashboard.putNumber("blue", color.blue);

        ColorMatchResult result = colorMatch.matchClosestColor(color);

        SmartDashboard.putNumber("confidence", result.confidence);

        for (WheelColor wheelColor : WheelColor.values()) {
            if (wheelColor.color == result.color) {
                SmartDashboard.putString("color", "" + wheelColor);

                return wheelColor;
            }
        }

        SmartDashboard.putString("color", "null");

        return null;
    }
}
