package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Deploy extends Command {

	public Deploy() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.stop();
	}

	@Override
	protected void execute() {
		Robot.intake.deploy();
	}

	@Override
	protected boolean isFinished() {
		return Robot.intake.isBottom();
	}

	@Override
	protected void end() {
		Robot.intake.stopDeploy();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
