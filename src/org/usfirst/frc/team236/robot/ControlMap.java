package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.lib.LogitechF310;

public class ControlMap {
	public static final int PORT_LEFT = 0;
	public static final int PORT_RIGHT = 1;
	public static final int PORT_CONTROLLER = 2;

	public static class Left {

	}

	public static class Right {

	}

	public static class Controller {
		public static final int CLIMB = LogitechF310.START;
		public static final int GARAGE_UP = LogitechF310.Y;
		public static final int GARAGE_DOWN = LogitechF310.A;
		// POV up: increment preset
		// POV down: decrement preset

		public static final int FEED = LogitechF310.RB;
		public static final int SHOOT = LogitechF310.LB;
		public static final int VARIABLE_FEED = LogitechF310.Axes.RT;
	}
}
