package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.lib.pixy.Pixy;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignWithPixy extends Command {

	Pixy pixy;

	public AlignWithPixy() {
		requires(Robot.tank);
	}

	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
