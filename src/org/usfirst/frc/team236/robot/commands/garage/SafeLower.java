package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SafeLower extends CommandGroup {

	public SafeLower() {
		addParallel(new Grasp());
		addParallel(new Secure());
		addParallel(new Wait(.5));
		addSequential(new Lower());
	}
}
