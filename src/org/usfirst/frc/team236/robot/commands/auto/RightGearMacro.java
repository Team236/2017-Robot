package org.usfirst.frc.team236.robot.commands.auto;

import org.usfirst.frc.team236.robot.commands.drive.PlayMacro;
import org.usfirst.frc.team236.robot.commands.garage.Lower;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightGearMacro extends CommandGroup {

	public RightGearMacro() {
		addSequential(new Lower());
		addSequential(new PlayMacro("rightgear"));
	}
}
