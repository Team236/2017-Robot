package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private SpeedController intakeMotor, deployMotor;
	private DigitalInput topLimit, bottomLimit;

	public Intake() {
		intakeMotor = new VictorSP(RobotMap.Intake.PWM_INTAKE);
		deployMotor = new VictorSP(RobotMap.Intake.PWM_DEPLOY);

		topLimit = new DigitalInput(RobotMap.Intake.DIO_LIMIT_TOP);
		bottomLimit = new DigitalInput(RobotMap.Intake.DIO_LIMIT_BOTTOM);
	}

	@Override
	protected void initDefaultCommand() {
	}

	private void setSpeed(double speed) {
		intakeMotor.set(speed);
	}

	public void intake() {
		setSpeed(RobotMap.Intake.INTAKE_SPEED);
	}

	public void eject() {
		setSpeed(RobotMap.Intake.EJECT_SPEED);
	}

	public void stop() {
		setSpeed(0);
	}

	/*
	 * DEPLOYMENT METHODS
	 */

	public boolean isTop() {
		return topLimit.get();
	}

	public boolean isBottom() {
		return bottomLimit.get();
	}

	/**
	 * Deploy (positive) or retract (negative) at the given speed
	 * 
	 * @param speed The speed of the motion. Positive will deploy.
	 */
	public void setDeploySpeed(double speed) {
		if (isTop() && speed < 0) {
			stopDeploy();
		} else if (isBottom() && speed > 0) {
			stopDeploy();
		} else {
			deployMotor.set(speed);
		}
	}

	/**
	 * Deploy the intake at the default speed
	 */
	public void deploy() {
		setDeploySpeed(RobotMap.Intake.DEPLOY_SPEED);
	}

	/**
	 * Stop the deploy motor
	 */
	public void stopDeploy() {
		deployMotor.stopMotor();
	}

	/**
	 * Retract the intake at the default speed
	 */
	public void retract() {
		setDeploySpeed(RobotMap.Intake.RETRACT_SPEED);
	}
}
