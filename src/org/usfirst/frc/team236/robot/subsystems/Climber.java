package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	private SpeedController motor;

	public Climber() {
		motor = new Spark(RobotMap.Climber.PWM_CLIMBER);
	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

	@Override
	protected void initDefaultCommand() {

	}
}
