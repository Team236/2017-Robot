package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author samcf
 */
public class GarageDoor extends Subsystem {

	// TODO come up with a better name for the vertical piston
	public DoubleSolenoid grasper, vertical;

	public GarageDoor() {
		grasper = new DoubleSolenoid(RobotMap.Garage.CHNL_GRASPER_FORWARD, RobotMap.Garage.CHNL_GRASPER_REVERSE);
		vertical = new DoubleSolenoid(RobotMap.Garage.CHNL_VERTICAL_FORWARD, RobotMap.Garage.CHNL_VERTICAL_REVERSE);
	}

	public void grasp() {
		grasper.set(Value.kReverse);
	}

	public void release() {
		grasper.set(Value.kForward);
	}

	public void raise() {
		vertical.set(Value.kReverse);
	}

	public void lower() {
		vertical.set(Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
	}
}
