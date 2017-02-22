package org.usfirst.frc.team236.robot.commands.camera;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraShooter extends Command {

	@Override
	protected void initialize() {
		Robot.cameraServo.set(RobotMap.CAMERA_POS[2]);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
