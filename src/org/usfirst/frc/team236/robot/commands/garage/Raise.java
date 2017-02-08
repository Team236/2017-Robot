package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Raise extends Command {

	public Raise(double timeout) {
		requires(Robot.garageDoor);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.garageDoor.raise();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after timeout
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
