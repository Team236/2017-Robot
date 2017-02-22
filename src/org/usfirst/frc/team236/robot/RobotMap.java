package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.subsystems.Shooter.Preset;

import pid.PIDParameters;

public class RobotMap {
	public static int[] DIO_SWITCHES = { 0, 1, 2 };

	public static final int PWM_CAM_SERVO = 8;
	//@formatter:off
	public static final double[] CAMERA_POS = {
		0.000, // Gear alignment
		0.250, // Gear loading
		0.750, // TODO High shooting
		1.000, // Shooting
	};
	//@formatter:on

	public static class Drive {
		// Uses PWM 0 and 1: split to two motors
		public static final int DIO_LEFT_ENC_A = 3;
		public static final int DIO_LEFT_ENC_B = 4;

		public static final int DIO_RIGHT_ENC_A = 5;
		public static final int DIO_RIGHT_ENC_B = 6;

		// Gearshift
		public static final int SOL_FORWARD = 0;
		public static final int SOL_REVERSE = 1;

		public static final double DIAMETER = 3.92;
		public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
		public static final double PULSE_PER_ROTATION = 128;
		public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;

		// TODO tune auto mode
		public static double kV_left = 0.018;
		public static double kV_right = 0.018;

		public static double kA = .000;
		public static double kP = .1;

		// TODO tune turning PID
		public static PIDParameters turnParams = new PIDParameters(0.01, 0.05, 0.000, 1 / 100.0);
	}

	public static class Shooter {
		public static final int PWM_SHOOTER = 2; // Splits to two motors
		public static final int PWM_FEEDER = 3;
		public static final int PWM_SERVO = 4;

		public static final int RELAY_LIGHT = 1;
		public static final int PDP_LIGHT = 4;

		public static final boolean INV_SHOOTER = true;
		public static final boolean INV_FEEDER = true;

		public static final int DIO_COUNTER = 7;

		public static final double DEFAULT_FEED_SPEED = 1.0;

		public static final double kV = 1 / 4600.0;

		@Deprecated
		public static final int RPM_INITIAL = 3200;
		@Deprecated
		public static final int RPM_INCREMENT = 100;

		public static class PID {
			public static final double kP = 0.001;
			public static final double kI = 0.000;
			public static final double kD = 0.000;
			public static final double interval = 1 / 200.0;
		}

		//@formatter:off
		public static final Preset[] PRESETS = {
			Robot.shooter.new Preset("Key", 3200, 24, 0.30),
			Robot.shooter.new Preset("DS", 3500, 80, 0.55),
			Robot.shooter.new Preset("Uber", 4000, 120, .65)
		};
		//@formatter:on
	}

	public static class Intake {
		public static final int PWM_INTAKE = 5; // Splits to two motors
		public static final int PWM_DEPLOY = 6;

		public static final boolean INV_DEPLOY = true;

		public static final int DIO_LIMIT_BOTTOM = 8;
		public static final int DIO_LIMIT_TOP = 9;

		public static final double INTAKE_SPEED = 1.00;
		public static final double EJECT_SPEED = -1.00;

		public static final double DEPLOY_SPEED = 0.70;
		public static final double RETRACT_SPEED = -1.00;
	}

	public static class Climber {
		public static final int PWM_CLIMBER = 7; // Splits to two motors 
		public static final double CLIMB_SPEED = 1.0;

		public static final boolean INV_CLIMBER = true;

		public static final int DIO_LIMIT = 10;
	}

	public static class Garage {
		public static final int SOL_GRASPER_FORWARD = 2;
		public static final int SOL_GRASPER_REVERSE = 3;

		public static final int SOL_VERTICAL_FORWARD = 4;
		public static final int SOL_VERTICAL_REVERSE = 5;

		public static final int RELAY_LIGHT = 0;
		public static final int PDP_LIGHT = 10;
	}
}
