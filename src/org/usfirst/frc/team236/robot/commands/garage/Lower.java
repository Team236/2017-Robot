package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Lower extends TimedCommand {

	public Lower(double timeout) {
		super(timeout);
		requires(Robot.garageDoor);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Called once after timeout
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
