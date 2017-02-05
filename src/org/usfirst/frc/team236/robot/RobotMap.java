package org.usfirst.frc.team236.robot;

public class RobotMap {
	public static class Drive {
		// Uses PWM 0 and 1: split to two motors
		public static final int DIO_LEFT_ENC_A = 0;
		public static final int DIO_LEFT_ENC_B = 1;

		public static final int DIO_RIGHT_ENC_A = 2;
		public static final int DIO_RIGHT_ENC_B = 3;

		// TODO: tune auto mode
		public static double kV_left, kV_right;
		public static double kA;
		public static double kP;

	}

	public static class Shooter {
		public static final int PWM_SHOOTER = 3; // Splits to two motors
		public static final int PWM_FEEDER = 4;

		public static final int DIO_BANNER = 4;
	}

	public static class Intake {
		public static final int PWM_INTAKE = 4; // Splits to two motors
		public static final int PWM_DEPLOY = 5;

		public static final int DIO_LIMIT_BOTTOM = 5;
	}

	public static class Climber {
		public static final int PWM_CLIMBER = 6; // Splits to two motors 

	}

	public static class Garage {
		public static final int PWM_DOOR = 7;
		public static final int PWM_FRAME = 8; // TODO: rename

	}
}
