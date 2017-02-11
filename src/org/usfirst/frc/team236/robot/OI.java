package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.CameraToggle;
import org.usfirst.frc.team236.robot.commands.climber.Climb;
import org.usfirst.frc.team236.robot.commands.drive.AlignDrive;
import org.usfirst.frc.team236.robot.commands.drive.ReversoDrive;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.shooter.ShootWithVariableFeed;
import org.usfirst.frc.team236.robot.lib.LogitechF310;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import ticktank.commands.ShiftDown;
import ticktank.commands.ShiftUp;

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
		// Left
		JoystickButton align = new JoystickButton(left, ControlMap.Left.ALIGN_DRIVE);
		align.whileHeld(new AlignDrive());

		JoystickButton shiftUp = new JoystickButton(left, ControlMap.Left.SHIFT_UP);
		shiftUp.whileHeld(new ShiftUp(Robot.tank));

		JoystickButton shiftDown = new JoystickButton(left, ControlMap.Left.SHIFT_DOWN);
		shiftDown.whileHeld(new ShiftDown(Robot.tank));

		// Right
		JoystickButton intake = new JoystickButton(right, ControlMap.Right.INTAKE);
		intake.whileHeld(new Intake());

		JoystickButton reverso = new JoystickButton(right, ControlMap.Right.REVERSO);
		reverso.whileHeld(new ReversoDrive());

		// Controller
		JoystickButton climb = new JoystickButton(controller, ControlMap.Controller.CLIMB);
		climb.whileHeld(new Climb());

		JoystickButton shoot = new JoystickButton(controller, ControlMap.Controller.SHOOT);
		shoot.whileHeld(new ShootWithVariableFeed());

		JoystickButton cameraToggle = new JoystickButton(controller, LogitechF310.BACK);
		cameraToggle.toggleWhenPressed(new CameraToggle());
	}
}
