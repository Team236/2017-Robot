package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	private SpeedController motor;

	private DigitalInput limit;
	
	public Climber() {
		motor = new Spark(RobotMap.Climber.PWM_CLIMBER);
		motor.setInverted(RobotMap.Climber.INV_CLIMBER);
		
		limit = new DigitalInput(RobotMap.Climber.DIO_LIMIT);
	}

	public void setSpeed(double speed) {
		if (!isTop()) {
			motor.set(speed);
		} else {
			stop();
		}
	}
	
	public boolean isTop() {
		return !limit.get();
	}

	public void stop() {
		motor.set(0);
	}

	@Override
	protected void initDefaultCommand() {

	}
}
