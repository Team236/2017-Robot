package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.AutoMap;
import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.garage.Lower;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.Direction;
import ticktank.commands.FollowProfile;
import ticktank.commands.Turn;

/**
 *
 */
public class AltRight extends CommandGroup {

    public AltRight() {
    	addSequential(new Lower());
    	addSequential(new FollowProfile(Robot.tank, Robot.altRight, true));
    	addSequential(new Turn(Robot.tank, AutoMap.altRightGearTurn, Direction.CCW));
    }
}
