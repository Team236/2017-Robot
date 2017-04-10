package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team236.robot.commands.garage.Grasp;
import org.usfirst.frc.team236.robot.commands.garage.Lower;

import edu.wpi.first.wpilibj.command.CommandGroup;
import ticktank.commands.ShiftUp;

/**
 *
 */
public class CenterWithGyro extends CommandGroup {

	public CenterWithGyro() {
		addParallel(new ShiftUp(Robot.tank));
		addParallel(new Grasp());
		addSequential(new Lower());
		addSequential(new DriveStraight(80));
	}
}
