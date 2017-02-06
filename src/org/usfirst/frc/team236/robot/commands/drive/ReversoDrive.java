package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot backwards
 * 
 * TODO: Do we need to stop the PID controller?
 */
public class ReversoDrive extends Command {

	public ReversoDrive() {
		requires(Robot.tank);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.tank.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.tank.setRightSpeed(Robot.oi.left.getRawAxis(0));
		Robot.tank.setLeftSpeed(Robot.oi.right.getRawAxis(0));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.tank.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
