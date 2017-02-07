package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import pid.PID;
import pid.PIDOutput;
import pid.PIDParameters;
import pid.PIDSource;
import ticktock.Ticker;

/**
 *
 */
public class Shooter extends Subsystem implements PIDOutput, PIDSource {

	private SpeedController motor;
	private Counter counter;
	private Servo servo;

	// PID objects
	public PID controller;
	private PIDParameters gains;
	public Ticker ticker;

	private double kV = RobotMap.Shooter.kV;

	public Shooter() {
		motor = new VictorSP(RobotMap.Shooter.PWM_SHOOTER);

		servo = new Servo(RobotMap.Shooter.PWM_SERVO);
		counter = new Counter(RobotMap.Shooter.DIO_COUNTER);

		gains = new PIDParameters(RobotMap.Shooter.PID.kP, RobotMap.Shooter.PID.kI, RobotMap.Shooter.PID.kD,
				RobotMap.Shooter.PID.interval);

		controller = new PID(this, this, gains);
		ticker = new Ticker(controller, gains.interval);

		controller.setSetpoint(RobotMap.Shooter.RPM_INITIAL);
	}

	@Override
	public void initDefaultCommand() {
		//setDefaultCommand(new SetShooterSpeed(3200));
	}

	/**
	 * Set the speed of the wheel directly
	 * 
	 * @param speed
	 *            the desired power, from -1 to 1
	 */
	public void setSpeedRaw(double speed) {
		motor.set(speed);
	}

	/**
	 * Set the goal RPM for the shooter
	 * 
	 * @param speed
	 *            RPM to set setpoint
	 */
	public void setSpeed(double speed) {
		this.controller.setSetpoint(speed);
	}

	/**
	 * Stop the flywheel immediately
	 */
	public void stop() {
		setSpeedRaw(0);
	}

	/**
	 * Calculate the rpm from the counter reading
	 * 
	 * @return the shooter RPM
	 */
	public double getRPM() {
		double RPM = 60 / counter.getPeriod();

		// Apply a filter to eliminate false positives
		if (RPM > 5000) {
			return controller.getSetpoint();
		}
		return RPM;
	}

	/**
	 * Convert an RPM to an approximate motor speed
	 * 
	 * @param RPM
	 *            The desired RPM
	 * @return The necessary motor speed (approximate)
	 */
	public double RPMtoMotorSpeed(double RPM) {
		return RPM * kV;
	}

	/**
	 * Convert an approximate motor speed to an RPM
	 * 
	 * @param motorSpeed
	 *            A motor speed
	 * @return The approximate RPM that will result
	 */
	public double motorSpeedToRPM(double motorSpeed) {
		return motorSpeed / kV;
	}

	// PID methods
	@Override
	public double pidGet() {
		return getRPM();
	}

	/**
	 * Set speed for PID.
	 * 
	 * @param speed
	 *            The adjustment we have to make to speed up the motor
	 */
	@Override
	public void pidSet(double speed) {
		// base speed is the motorspeed that we start with
		double baseSpeed = RPMtoMotorSpeed(controller.getSetpoint());
		setSpeedRaw(baseSpeed + speed);
		SmartDashboard.putNumber("Motor output", baseSpeed + speed);
	}
}
