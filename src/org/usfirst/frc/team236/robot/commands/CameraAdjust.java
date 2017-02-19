package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.lib.LogitechF310;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraAdjust extends Command {

	public CameraAdjust() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.cameraServo.set(Robot.oi.controller.getRawAxis(LogitechF310.Axes.LEFT_Y));
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
