package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Eject extends Command {

	public Eject() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.stop();
	}

	@Override
	protected void execute() {
		Robot.intake.eject();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
