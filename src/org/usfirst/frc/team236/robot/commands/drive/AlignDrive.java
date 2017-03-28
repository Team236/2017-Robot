package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.lib.Thrustmaster;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the drive in arcade mode with the speed scaled down significantly to
 * aid precise alignment with field elements. Change speedfactor and turnFactor
 * to adjust the speed of forward and rotational movement, respectively. Derry
 * doesn't like this and Hayden doesn't use it so it is deprecated.
 * 
 * @author samcf
 * @deprecated
 */
@Deprecated
public class AlignDrive extends Command {
	public static double speedFactor = 0.5;
	public static double turnFactor = 0.5;

	public AlignDrive() {
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
		double y = Robot.oi.left.getRawAxis(Thrustmaster.Axes.Y);
		double z = Robot.oi.left.getRawAxis(Thrustmaster.Axes.Z);

		double leftSpeed = speedFactor * y;
		double rightSpeed = speedFactor * y;

		leftSpeed += turnFactor * z;
		rightSpeed -= turnFactor * z;

		Robot.tank.setLeftSpeed(leftSpeed);
		Robot.tank.setRightSpeed(rightSpeed);
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
