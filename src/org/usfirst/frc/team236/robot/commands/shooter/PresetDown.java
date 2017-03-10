package org.usfirst.frc.team236.robot.commands.shooter;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PresetDown extends Command {

	@Override
	public void initialize() {
		Robot.shooter.presetDown();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
