package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.climber.Climb;
import org.usfirst.frc.team236.robot.commands.drive.ReversoDrive;
import org.usfirst.frc.team236.robot.commands.shooter.ShootWithVariableFeed;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick left, right;
	public Joystick controller;

	public OI() {
		// Joysticks + controller
		left = new Joystick(ControlMap.PORT_LEFT);
		right = new Joystick(ControlMap.PORT_RIGHT);
		controller = new Joystick(ControlMap.PORT_CONTROLLER);

		// Add buttons below
		JoystickButton climb = new JoystickButton(controller, ControlMap.Controller.CLIMB);
		climb.whileHeld(new Climb());

		JoystickButton invert = new JoystickButton(left, ControlMap.Left.INVERT);
		invert.toggleWhenPressed(new ReversoDrive());

		JoystickButton shoot = new JoystickButton(controller, ControlMap.Controller.SHOOT);
		shoot.whileHeld(new ShootWithVariableFeed());
	}
}
