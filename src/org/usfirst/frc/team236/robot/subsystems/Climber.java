package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class Climber {

	private SpeedController motor;

	public Climber() {
		motor = new Spark(RobotMap.Climber.PWM_CLIMBER);
	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

}
