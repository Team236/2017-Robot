package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Retract extends Command {

	public Retract() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.stop();
	}

	@Override
	protected void execute() {
		Robot.intake.retract();
	}

	@Override
	protected boolean isFinished() {
		return Robot.intake.isTop();
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
