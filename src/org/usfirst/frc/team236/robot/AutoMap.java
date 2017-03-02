package org.usfirst.frc.team236.robot;

import ticktank.motionProfile.DriveParameters;
import ticktank.motionProfile.ProfileParameters;

public final class AutoMap {
	// Straight gear delivery
	public static final ProfileParameters straightGear = new ProfileParameters(82, 80, 50, 10);

	// Right gear delivery
	public static final ProfileParameters rightGearLeg1 = new ProfileParameters(94.5, 20, 2, 10);
	public static final double rightGearDegrees = 60;
	public static final ProfileParameters rightGearLeg2 = new ProfileParameters(34.5, 20, 2, 10);

	// Alt Right
	public static final ProfileParameters altRightGear = new ProfileParameters(128, 80, 50, 10);
	public static final double altRightGearTurn = 10;

	// Bend Right
	public static final ProfileParameters rightBendLeftSide = new ProfileParameters(172, 64, 64, 128);
	public static final ProfileParameters leftBendLeftSide = new ProfileParameters(168, 60, 60, 120);

	// Left gear delivery
	public static final ProfileParameters leftGearLeg1 = new ProfileParameters(94.4, 30, 2, 10);
	public static final double leftTurnDegrees = 60;
	public static final ProfileParameters leftGearLeg2 = new ProfileParameters(23.6, 30, 2, 10);

	// General Parameters
	public static final DriveParameters leftParams = new DriveParameters(RobotMap.Drive.kV_left, RobotMap.Drive.kA,
			RobotMap.Drive.kP);

	public static final DriveParameters rightParams = new DriveParameters(RobotMap.Drive.kV_right, RobotMap.Drive.kA,
			RobotMap.Drive.kP);
}
