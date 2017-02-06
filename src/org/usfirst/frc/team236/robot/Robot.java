
package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.GarageDoor;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import ticktank.ControllerType;
import ticktank.Settings;
import ticktank.TickTank;
import ticktank.motionProfile.Profile;

public class Robot extends IterativeRobot {

	public static OI oi;

	// Subsystems
	public static TickTank tank;
	public static Intake intake;
	public static Climber climber;
	public static Shooter shooter;
	public static GarageDoor garageDoor;

	// Profiles
	public static Profile straightGearDelivery;
	public static Profile rightGearLeg1;
	public static Profile rightGearLeg2;

	public static Profile leftGearLeg1;
	public static Profile leftGearLeg2;

	// Compressor
	private Compressor compressor;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		// Configure drive
		Settings config = new Settings();
		config.controllerType = ControllerType.VICTORSP;
		config.hasEncoders = true;
		config.motorCount = 1;
		config.leftStick = new Joystick(0);
		config.rightStick = new Joystick(1);
		config.hasGears = true;
		config.hasGyro = true;

		// Encoder ports
		config.leftEncoderA = RobotMap.Drive.DIO_LEFT_ENC_A;
		config.leftEncoderB = RobotMap.Drive.DIO_LEFT_ENC_B;
		config.rightEncoderA = RobotMap.Drive.DIO_RIGHT_ENC_A;
		config.rightEncoderB = RobotMap.Drive.DIO_RIGHT_ENC_B;
		config.rightInvEncoder = true;

		config.rightInv = true;
		config.dpp = RobotMap.Drive.DISTANCE_PER_PULSE;
		config.leftParams = AutoMap.leftParams;
		config.rightParams = AutoMap.rightParams;
		config.turnParams = RobotMap.Drive.turnParams;

		// Instantiate subsystems
		tank = new TickTank(config);
		shooter = new Shooter();
		intake = new Intake();
		garageDoor = new GarageDoor();
		climber = new Climber();

		// Instantiate OI
		oi = new OI();

		// Start compressor
		compressor = new Compressor();
		compressor.start();

		// Select auto
		// chooser.addDefault("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);

		// Send camera to SmartDash
		try {
			UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
			cam.setResolution(640, 480);
		} catch (Exception e) {
			System.out.println("Camera capture failed");
		}
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/*
	 * TODO: Figure out how to use pov for shooter speed adjustment
	 */
	@Override
	public void teleopPeriodic() {
		// SmartDashboard code
		SmartDashboard.putNumber("RPM", Robot.shooter.getRPM());
		SmartDashboard.putNumber("Goal RPM", Robot.shooter.controller.getSetpoint());

		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
