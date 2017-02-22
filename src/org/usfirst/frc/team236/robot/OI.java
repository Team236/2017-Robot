package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.camera.CameraToggle;
import org.usfirst.frc.team236.robot.commands.climber.Climb;
import org.usfirst.frc.team236.robot.commands.drive.AlignDrive;
import org.usfirst.frc.team236.robot.commands.drive.ReversoDrive;
import org.usfirst.frc.team236.robot.commands.garage.Grasp;
import org.usfirst.frc.team236.robot.commands.garage.Release;
import org.usfirst.frc.team236.robot.commands.intake.Deploy;
import org.usfirst.frc.team236.robot.commands.intake.Intake;
import org.usfirst.frc.team236.robot.commands.intake.Retract;
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
		// Left
		JoystickButton align = new JoystickButton(left, ControlMap.Left.ALIGN_DRIVE);
		align.whileHeld(new AlignDrive());

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

		JoystickButton retract = new JoystickButton(controller, ControlMap.Controller.RETRACT_INTAKE);
		retract.whileHeld(new Retract());

		JoystickButton deploy = new JoystickButton(controller, ControlMap.Controller.DEPLOY_INTAKE);
		deploy.whileHeld(new Deploy());

		JoystickButton cameraToggle = new JoystickButton(controller, ControlMap.Controller.TOGGLE_CAMERA);
		cameraToggle.toggleWhenPressed(new CameraToggle());

		JoystickButton grasp = new JoystickButton(controller, ControlMap.Controller.GRASP);
		grasp.whenPressed(new Grasp());

		JoystickButton release = new JoystickButton(controller, ControlMap.Controller.RELEASE);
		release.whenPressed(new Release());

		JoystickButton adjustCamera = new JoystickButton(controller, ControlMap.Controller.ADJUST_CAMERA);
		//adjustCamera.whileHeld(new CameraAdjust());
	}
}
