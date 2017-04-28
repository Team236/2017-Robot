package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.Wait;
import org.usfirst.frc.team236.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team236.robot.commands.garage.Release;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.Direction;
import ticktank.commands.FollowProfile;
import ticktank.commands.Turn;

/**
 *
 */
public class RightAutoDeposit extends CommandGroup {

    public RightAutoDeposit() {
        addSequential(new RightAuto());
        addSequential(new Wait(0.5));
        addSequential(new Release());
        addSequential(new DriveStraight(.10, -30, .8));
        addSequential(new Turn(Robot.tank, 60, Direction.CCW));
        addSequential(new DriveStraight(.10, 120, -1.0));
    }
}
