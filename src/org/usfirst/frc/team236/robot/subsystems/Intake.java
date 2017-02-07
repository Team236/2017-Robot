package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private SpeedController intakeMotor, deployMotor;

	public Intake() {
		intakeMotor = new VictorSP(RobotMap.Intake.PWM_INTAKE);
		deployMotor = new VictorSP(RobotMap.Intake.PWM_DEPLOY);
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

	public void setDeploySpeed(double speed) {
		deployMotor.set(speed);
	}

	public void deploy() {
		setDeploySpeed(RobotMap.Intake.DEPLOY_SPEED);
	}

	public void retract() {
		setDeploySpeed(RobotMap.Intake.RETRACT_SPEED);
	}
}
