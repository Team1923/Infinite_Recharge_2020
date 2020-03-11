package frc.team1923.robot;

import frc.team1923.robot.utilities.motor.SparkMaxMotor;
import frc.team1923.robot.utilities.motor.TalonFXMotor;
import frc.team1923.robot.utilities.motor.group.Group;
import frc.team1923.robot.utilities.motor.group.MotorGroup;

public final class Constants {
    private Constants() {}

    public static final class Drive {
        private Drive() {}

        public static final MotorGroup<TalonFXMotor> LEFT = new Group<TalonFXMotor>(1, 2, 3);
        public static final MotorGroup<TalonFXMotor> RIGHT = new Group<TalonFXMotor>(4, 5, 6).inverting();
    }

    public static final class Shooter {
        private Shooter() {}

        public static final MotorGroup<TalonFXMotor> SHOOTER = new Group<TalonFXMotor>(7, 8, 9).inverting().ramping(0.5).withPIDF(0.2, 0, 0, 0.05);
    }

    public static final class Intake {
        private Intake() {}

        public static final MotorGroup<SparkMaxMotor> INTAKE = new Group<SparkMaxMotor>(12);
    }

    public static final class Indexer {
        private Indexer() {}

        public static final MotorGroup<SparkMaxMotor> INDEXER = new Group<SparkMaxMotor>(11);
    }

    public static final class Conveyor {
        private Conveyor() {}

        public static final MotorGroup<SparkMaxMotor> CONVEYOR = new Group<SparkMaxMotor>(14).inverting();

        public static final int INDEXER_HAS_BALL_SENSOR = 0;
        public static final int CONVEYOR_HAS_BALL_SENSOR = 1;
        public static final int TURRET_HAS_BALL_SENSOR = 2;
    }

    public static final class Turret {
        private Turret() {}

        public static final double TURRET_RATIO = 27 * 120 / 22.0;

        public static final MotorGroup<SparkMaxMotor> TURRET = new Group<SparkMaxMotor>(10).softLimiting(-TURRET_RATIO / 4, TURRET_RATIO * 5 / 4).withPIDF(0.04, 0, 0, 0);

        public static final int IS_AT_ZERO_SENSOR = 3;
    }

    public static final class Climber {
        private Climber() {}

        public static final MotorGroup<TalonFXMotor> CLIMBER = new Group<TalonFXMotor>(15);
    }

    public static final class Controllers {
        private Controllers() {}

        public static final int DRIVER = 0;
        public static final int OPERATOR = 1;
    }
}
