package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.garage.Raise;
import org.usfirst.frc.team236.robot.commands.garage.StoppedLower;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author samcf
 */
public class Garage extends Subsystem {

	// TODO come up with a better name for the vertical piston
	public DoubleSolenoid grasper, vertical;
	private Relay light;

	public Garage() {
		grasper = new DoubleSolenoid(RobotMap.Garage.SOL_GRASPER_FORWARD, RobotMap.Garage.SOL_GRASPER_REVERSE);
		vertical = new DoubleSolenoid(RobotMap.Garage.SOL_VERTICAL_FORWARD, RobotMap.Garage.SOL_VERTICAL_REVERSE);

		light = new Relay(org.usfirst.frc.team236.robot.RobotMap.Garage.RELAY_LIGHT);
		light.setDirection(Direction.kForward);
	}

	public void lightOn() {
		light.set(edu.wpi.first.wpilibj.Relay.Value.kForward);
	}

	public void lightOff() {
		light.set(edu.wpi.first.wpilibj.Relay.Value.kOff);
	}

	/**
	 * Checks controller d-pad to automatically move the garage door when the
	 * appropriate button is pressed
	 */
	public void handleHeight() {
		int ang = Robot.oi.controller.getPOV(0);

		if (ang == 0) {
			new Raise().start();
		} else if (ang == 180) {
			new StoppedLower().start();
		}
	}

	public void grasp() {
		grasper.set(Value.kForward);
	}

	public void release() {
		grasper.set(Value.kReverse);
	}

	public void raise() {
		vertical.set(Value.kForward);
	}

	public void lower() {
		vertical.set(Value.kReverse);
	}

	@Override
	protected void initDefaultCommand() {
	}
}
