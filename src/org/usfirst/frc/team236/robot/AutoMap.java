package org.usfirst.frc.team236.robot;

import ticktank.motionProfile.DriveParameters;
import ticktank.motionProfile.ProfileParameters;

public final class AutoMap {
	// Straight gear delivery
	public static final ProfileParameters straightGear = new ProfileParameters(78.9, 80, 50, 10);

	// Right gear delivery
	public static final ProfileParameters rightGearLeg1 = new ProfileParameters(94.5, 20, 2, 10);
	public static final double rightGearDegrees = 60;
	public static final ProfileParameters rightGearLeg2 = new ProfileParameters(34.5, 20, 2, 10);

	// Left gear delivery
	public static final ProfileParameters leftGearLeg1 = new ProfileParameters(70.9, 30, 2, 10);
	public static final double leftTurnDegreees = 60;
	public static final ProfileParameters leftGearLeg2 = new ProfileParameters(69.5, 30, 2, 10);

	// General Parameters
	public static final DriveParameters leftParams = new DriveParameters(RobotMap.Drive.kV_left, RobotMap.Drive.kA,
			RobotMap.Drive.kP);
	public static final DriveParameters rightParams = new DriveParameters(RobotMap.Drive.kV_right, RobotMap.Drive.kA,
			RobotMap.Drive.kP);
}
