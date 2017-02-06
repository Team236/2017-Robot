package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * TODO: Determine grasp strength
 * TODO: Determine limit switches and behavior
 * TODO: Pick a mechanism to raise and lower door
 * TODO: Harass gear team to finish mechanism
 * 
 * @author samcf
 */
public class GarageDoor {

	private SpeedController grasper;

	public GarageDoor() {
		grasper = new Spark(RobotMap.Garage.PWM_GRASPER);
	}

	public void grasp(double speed) {
		if (speed > 0) {
			grasper.set(speed);
		}
	}

	public void grasp() {
		grasp(RobotMap.Garage.GRASP_STRENGTH);
	}
}
