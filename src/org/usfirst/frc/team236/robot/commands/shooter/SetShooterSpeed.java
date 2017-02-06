package org.usfirst.frc.team236.robot.commands.shooter;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Set the wheel speed to a given RPM and hold that speed
 */
public class SetShooterSpeed extends Command {

	private double setpoint;

	public SetShooterSpeed(double RPM) {
		requires(Robot.shooter);

		this.setpoint = RPM;
	}

	@Override
	protected void initialize() {
		Robot.shooter.setSpeed(setpoint);
		Robot.shooter.ticker.start();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	/*
	 * These two stop() need to be in this order because the ticker runs very
	 * fast. If they're backwards, there's a good chance that the pid loop 
	 * could try to set the speed of the motor before it stops. That would 
	 * leave the shooter still spinning after the command ended.
	 */
	@Override
	protected void end() {
		Robot.shooter.ticker.stop(); // Stop the pid controller
		Robot.shooter.stop(); // Stop the motor
	}

	@Override
	protected void interrupted() {
		end();
	}
}
