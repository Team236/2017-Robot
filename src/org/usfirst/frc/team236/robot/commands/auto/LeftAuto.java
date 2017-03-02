package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.Wait;
import org.usfirst.frc.team236.robot.commands.garage.Lower;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.Direction;
import ticktank.commands.FollowProfile;
import ticktank.commands.Turn;

/**
 *
 */
public class LeftAuto extends CommandGroup {

	public LeftAuto() {
		addSequential(new Lower());
		addSequential(new FollowProfile(Robot.tank, Robot.leftGearLeg1, true));
		addSequential(new Turn(Robot.tank, AutoMap.leftTurnDegrees, Direction.CW));
		addSequential(new Wait(0));
		addSequential(new FollowProfile(Robot.tank, Robot.leftGearLeg2, true));
	}
}
