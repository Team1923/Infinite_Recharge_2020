package frc.team1923.robot;

import frc.team1923.robot.utilities.SparkMaxGroup;
import frc.team1923.robot.utilities.TalonFXGroup;

public final class Constants {
    private Constants() {}

    public static final class Drivetrain {
        private Drivetrain() {}

        public static final TalonFXGroup LEFT = new TalonFXGroup(1, 2, 3);
        public static final TalonFXGroup RIGHT = new TalonFXGroup(4, 5, 6).inverting();
    }

    public static final class Turret {
        private Turret() {}

        public static final TalonFXGroup SHOOTER = new TalonFXGroup(7, 8, 9).inverting().coasting();
    }

    public static final class Intake {
        private Intake() {}

        public static final SparkMaxGroup INTAKE = new SparkMaxGroup(10, 11, 12);
    }

    public static final class ControlPanel {
        private ControlPanel() {}

        public static final SparkMaxGroup SPINNER = new SparkMaxGroup(13);
    }

    public static final class Controllers {
        private Controllers() {}

        public static final int DRIVER = 0;
        public static final int OPERATOR = 1;
    }
}
