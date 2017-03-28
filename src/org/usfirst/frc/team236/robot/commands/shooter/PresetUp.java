package org.usfirst.frc.team236.robot.commands.shooter;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PresetUp extends Command {

	@Override
	public void initialize() {
		Robot.shooter.presetUp();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
