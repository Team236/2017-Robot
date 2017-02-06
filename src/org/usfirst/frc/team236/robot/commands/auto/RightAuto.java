package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.Direction;
import ticktank.commands.FollowProfile;
import ticktank.commands.Turn;

/**
 *
 */
public class RightAuto extends CommandGroup {

	public RightAuto() {
		addSequential(new FollowProfile(Robot.tank, Robot.rightGearLeg1, false));
		addSequential(new Turn(Robot.tank, AutoMap.rightGearDegrees, Direction.CCW));
		addSequential(new Wait(0));
		addSequential(new FollowProfile(Robot.tank, Robot.rightGearLeg2, false));
	}
}
