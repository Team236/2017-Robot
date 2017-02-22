package org.usfirst.frc.team236.robot.commands.camera;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraCycle extends Command {

	private static int n = 0;

	public CameraCycle() {
	}

	@Override
	protected void initialize() {
		Robot.cameraServo.set(RobotMap.CAMERA_POS[n % RobotMap.CAMERA_POS.length]);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		n++;
	}

	@Override
	protected void interrupted() {
		end();
	}
}
