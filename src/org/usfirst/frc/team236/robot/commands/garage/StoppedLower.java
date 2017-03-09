package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.commands.drive.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StoppedLower extends CommandGroup {

	public StoppedLower() {
		addParallel(new Stop(), 0.5);
		addParallel(new Grasp());
		addParallel(new Lower());
	}
}
