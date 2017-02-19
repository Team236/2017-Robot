package org.usfirst.frc.team236.robot.commands.garage;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SafeLower extends CommandGroup {

	public SafeLower() {
		addSequential(new Grasp());
		addSequential(new Lower());
	}
}
