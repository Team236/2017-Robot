package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.commands.Wait;
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
    	addSequential(new ShiftUp(Robot.tank));
    	addSequential(new Grasp());
    	addSequential(new Lower());
    	addSequential(new Wait(1));
		addSequential(new DriveStraight(80));
    }
}
