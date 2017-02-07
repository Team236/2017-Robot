package org.usfirst.frc.team236.robot.commands.garage;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.lib.LogitechF310;

import edu.wpi.first.wpilibj.command.Command;

public class GarageWithJoystick extends Command {

	public GarageWithJoystick() {
		requires(Robot.garageDoor);
	}

	@Override
	protected void initialize() {
		Robot.garageDoor.stop();
	}

	// TODO: test direction
	@Override
	protected void execute() {
		Robot.garageDoor.setSpeed(Robot.oi.controller.getRawAxis(LogitechF310.Axes.RIGHT_Y));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.garageDoor.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
