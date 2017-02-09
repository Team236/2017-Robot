package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author samcf
 */
public class Garage extends Subsystem {

	// TODO come up with a better name for the vertical piston
	public DoubleSolenoid grasper, vertical;

	public Garage() {
		grasper = new DoubleSolenoid(RobotMap.Garage.SOL_GRASPER_FORWARD, RobotMap.Garage.SOL_GRASPER_REVERSE);
		vertical = new DoubleSolenoid(RobotMap.Garage.SOL_VERTICAL_FORWARD, RobotMap.Garage.SOL_VERTICAL_REVERSE);
	}
	
	public void handleHeight() {
		int ang = Robot.oi.controller.getPOV(0);
		
		if (ang == 0) {
			raise();
		} else if (ang == 180) {
			lower();
		}
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
