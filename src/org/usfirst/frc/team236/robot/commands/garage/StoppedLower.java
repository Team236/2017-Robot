package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StoppedLower extends Command {

	private int i = 0;

	public StoppedLower() {
		requires(Robot.garage);
		requires(Robot.tank);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.garage.grasp();
		Robot.garage.light.safeOn();
		Robot.tank.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (i / 50 > 0.5) {
			Robot.garage.lower();
		}
		i++;
	}

	@Override
	protected boolean isFinished() {
		return (i / 50 > 1);
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
