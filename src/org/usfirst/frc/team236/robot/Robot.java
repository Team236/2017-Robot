
package org.usfirst.frc.team236.robot;

import java.util.ArrayList;

import org.usfirst.frc.team236.robot.commands.auto.LeftAuto;
import org.usfirst.frc.team236.robot.commands.auto.RightAuto;
import org.usfirst.frc.team236.robot.commands.auto.StraightAuto;
import org.usfirst.frc.team236.robot.lib.AutoHandler;
import org.usfirst.frc.team236.robot.subsystems.Climber;
import org.usfirst.frc.team236.robot.subsystems.Garage;
import org.usfirst.frc.team236.robot.subsystems.Intake;
import org.usfirst.frc.team236.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
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
	public static Garage garage;

	// Profiles
	public static Profile straightGearDelivery;
	public static Profile rightGearLeg1;
	public static Profile rightGearLeg2;

	public static Profile leftGearLeg1;
	public static Profile leftGearLeg2;

	AutoHandler autoHandler;

	// Compressor
	private Compressor compressor;

	// Camera servo
	public static Servo cameraServo;
	public UsbCamera camera;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static PowerDistributionPanel panel;

	@Override
	public void robotInit() {
		// Configure drive
		Settings config = new Settings();
		config.controllerType = ControllerType.VICTORSP;
		config.hasEncoders = true;
		config.motorCount = 1;
		config.leftStick = new Joystick(0);
		config.rightStick = new Joystick(1);
		config.hasGyro = true;

		// Gear config
		config.hasGears = true;
		config.solForward = RobotMap.Drive.SOL_FORWARD;
		config.solReverse = RobotMap.Drive.SOL_REVERSE;

		// Encoder ports
		config.leftEncoderA = RobotMap.Drive.DIO_LEFT_ENC_A;
		config.leftEncoderB = RobotMap.Drive.DIO_LEFT_ENC_B;
		config.rightEncoderA = RobotMap.Drive.DIO_RIGHT_ENC_A;
		config.rightEncoderB = RobotMap.Drive.DIO_RIGHT_ENC_B;
		config.rightInvEncoder = true;

		// Driving parameters
		config.rightInv = true;
		config.dpp = RobotMap.Drive.DISTANCE_PER_PULSE;
		config.leftParams = AutoMap.leftParams;
		config.rightParams = AutoMap.rightParams;
		config.turnParams = RobotMap.Drive.turnParams;

		// Instantiate subsystems
		tank = new TickTank(config);
		shooter = new Shooter();
		intake = new Intake();
		garage = new Garage();
		climber = new Climber();

		// Instantiate OI
		oi = new OI();

		// Start compressor
		compressor = new Compressor();
		compressor.start();

		// PDP
		panel = new PowerDistributionPanel();

		// Select auto
		chooser.addDefault("Straight Center", new StraightAuto(tank, straightGearDelivery));
		chooser.addObject("Left", new LeftAuto());
		chooser.addObject("Right", new RightAuto());
		//SmartDashboard.putData("Auto mode", chooser);

		// Use switches
		autoHandler = new AutoHandler(RobotMap.DIO_SWITCHES);

		cameraServo = new Servo(RobotMap.PWM_CAM_SERVO);

		try {
			camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480); // TODO what resolution should we used?
			camera.setFPS(30);
		} catch (Exception e) { // TODO what exception do we use here?
			System.out.println("Camera capture failed");
			System.out.println(e.getStackTrace());
		}
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Switches", autoHandler.getSelected());
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		ArrayList<CommandGroup> autoCommands = new ArrayList<CommandGroup>();
		autoCommands.add(new StraightAuto(tank, straightGearDelivery));

		//autonomousCommand = autoCommands.get(autoHandler.getSelected());

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
		garage.lightOn();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		// SmartDashboard code
		// General
		SmartDashboard.putNumber("Match time", DriverStation.getInstance().getMatchTime());
		SmartDashboard.putNumber("Voltage", DriverStation.getInstance().getBatteryVoltage());

		// Shooter
		SmartDashboard.putNumber("RPM", Robot.shooter.getRPM());
		SmartDashboard.putNumber("Angle", Robot.shooter.getAngle());
		SmartDashboard.putNumber("Goal RPM", Robot.shooter.controller.getSetpoint());
		SmartDashboard.putString("Preset", Robot.shooter.getPreset().toString());

		// Intake
		SmartDashboard.putBoolean("Bottom", intake.isBottom());
		SmartDashboard.putBoolean("Top", intake.isTop());

		// Climber
		SmartDashboard.putBoolean("Climber", climber.isTop());

		SmartDashboard.putNumber("Shooter draw", panel.getCurrent(RobotMap.Shooter.PDP_LIGHT));
		SmartDashboard.putNumber("Garage draw", panel.getCurrent(RobotMap.Garage.PDP_LIGHT));

		// Subsystem control handlers
		shooter.handlePresets();
		garage.handleHeight();

		// Handle shifting
		if (oi.left.getPOV(0) == 0) {
			tank.shiftUp();
		} else if (oi.left.getPOV(0) == 180) {
			tank.shiftDown();
		}

		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
