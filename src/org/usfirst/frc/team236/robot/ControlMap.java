package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.lib.LogitechF310;
import org.usfirst.frc.team236.robot.lib.Thrustmaster;

public class ControlMap {
	public static final int PORT_LEFT = 0;
	public static final int PORT_RIGHT = 1;
	public static final int PORT_CONTROLLER = 2;

	public static class Left {
		public static final int ALIGN_DRIVE = Thrustmaster.BUTTON_MIDDLE; // Lower button

		public static final int SHIFT_UP = Thrustmaster.BUTTON_LEFT;
		public static final int SHIFT_DOWN = Thrustmaster.BUTTON_RIGHT;
	}

	public static class LeftAttack3 {
		public static final int ALIGN_DRIVE = 4; // Lower button

		public static final int SHIFT_UP = 3;
		public static final int SHIFT_DOWN = 2;
	}

	public static class Right {
		public static final int INTAKE = Thrustmaster.BUTTON_MIDDLE;

		public static final int REVERSO = Thrustmaster.TRIGGER;
	}

	public static class RightAttack3 {
		public static final int INTAKE = 2;

		public static final int REVERSO = 1;
	}

	public static class Controller {
		// POV left: increment preset
		// POV right: decrement preset
		// POV up: garage up
		// POV down: garage down

		public static final int CLIMB = LogitechF310.START;

		public static final int FEED = LogitechF310.RB;
		public static final int SHOOT = LogitechF310.LB;
		public static final int VARIABLE_FEED = LogitechF310.Axes.LT;

		public static final int RETRACT_INTAKE = LogitechF310.Y;
		public static final int DEPLOY_INTAKE = LogitechF310.A;

		public static final int CYCLE_CAMERA = LogitechF310.BACK;
		@Deprecated
		public static final int ADJUST_CAMERA = LogitechF310.LEFT_PRESS;

		public static final int GRASP = LogitechF310.B;
		public static final int RELEASE = LogitechF310.X;
	}
}
