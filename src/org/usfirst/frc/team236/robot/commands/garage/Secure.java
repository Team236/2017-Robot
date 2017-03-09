package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Secure extends Command {

	public Secure() {
		// Don't require garage because it operates independently
	}

	@Override
	protected void initialize() {
		Robot.garage.safetyOn();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.garage.safetyOff();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
