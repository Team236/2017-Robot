package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Determine grasp strength
 * TODO: Determine limit switches and behavior
 * TODO: Pick a mechanism to raise and lower door
 * TODO: Harass gear team to finish mechanism
 * 
 * @author samcf
 */
public class GarageDoor extends Subsystem {

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

	public void setSpeed(double speed) {

	}

	public void raise() {
		this.raise(RobotMap.Garage.RAISE_SPEED);
	}

	public void raise(double speed) {

	}

	public void lower() {
		this.lower(RobotMap.Garage.LOWER_SPEED);
	}

	public void lower(double speed) {

	}

	@Override
	protected void initDefaultCommand() {
	}
}
