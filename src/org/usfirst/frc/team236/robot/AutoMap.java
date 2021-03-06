package org.usfirst.frc.team236.robot;

import ticktank.motionProfile.DriveParameters;
import ticktank.motionProfile.ProfileParameters;

public final class AutoMap {
	// General Parameters
	public static final DriveParameters leftParams = new DriveParameters(RobotMap.Drive.kV_left, RobotMap.Drive.kA,
			RobotMap.Drive.kP);

	public static final DriveParameters rightParams = new DriveParameters(RobotMap.Drive.kV_right, RobotMap.Drive.kA,
			RobotMap.Drive.kP);

	public static final double turnMargin = 3; // degrees
	public static final double profileMargin = 2; // inches

	// Straight gear delivery
	public static final ProfileParameters straightGear = new ProfileParameters(82, 60, 100, 300, profileMargin);

	// Right gear delivery
	public static final ProfileParameters rightGearLeg1 = new ProfileParameters(91, 60, 100, 200, profileMargin);
	public static final double rightGearTurnDegrees = 60;
	public static final ProfileParameters rightGearLeg2 = new ProfileParameters(30, 20, 200, 400, profileMargin);

	// Left gear delivery
	public static final ProfileParameters leftGearLeg1 = new ProfileParameters(91, 60, 100, 200, profileMargin);
	public static final double leftGearTurnDegrees = 60;
	public static final ProfileParameters leftGearLeg2 = new ProfileParameters(30, 20, 200, 400, profileMargin);
}
