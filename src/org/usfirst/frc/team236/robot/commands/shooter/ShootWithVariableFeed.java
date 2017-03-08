package org.usfirst.frc.team236.robot.commands.shooter;

import org.usfirst.frc.team236.robot.ControlMap;
import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the shooter with whatever setpoint is given
 * 
 * @author samcf
 *
 */
public class ShootWithVariableFeed extends Command {

	public ShootWithVariableFeed() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.lightOn();
		Robot.garage.lower();
		Robot.shooter.controller.setSetpoint(Robot.shooter.getPreset().RPM);

		Robot.shooter.ticker.start();
	}

	@Override
	protected void execute() {
		Robot.shooter.feed(Robot.oi.controller.getRawAxis(ControlMap.Controller.VARIABLE_FEED) * 0.4);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.lightOff();
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
