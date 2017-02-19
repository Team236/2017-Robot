package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grasp extends Command {

	public Grasp() {
		requires(Robot.garage);
	}

	protected void initialize() {
		Robot.garage.grasp();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}
}
