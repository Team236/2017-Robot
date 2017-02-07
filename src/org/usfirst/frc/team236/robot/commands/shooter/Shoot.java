package org.usfirst.frc.team236.robot.commands.shooter;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the shooter with whatever setpoint is given
 * 
 * @author samcf
 *
 */
public class Shoot extends Command {

	public Shoot() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.controller.setSetpoint(Robot.shooter.getPreset().RPM);
		Robot.shooter.setAngle(Robot.shooter.getPreset().angle);

		Robot.shooter.ticker.start();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.ticker.stop();
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
