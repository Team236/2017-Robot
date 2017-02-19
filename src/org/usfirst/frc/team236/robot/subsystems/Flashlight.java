package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;

public class Flashlight extends Relay {
	
	private int pdpPort;

	public Flashlight(int channel, int _pdpPort) {
		super(channel);
		super.setDirection(Direction.kForward);
		
		this.pdpPort = _pdpPort;
	}

	/**
	 * Turn on the flashlight
	 */
	public void on() {
		super.set(Value.kForward);
	}

	/**
	 * Turn off the flashlight
	 */
	public void off() {
		super.set(Value.kOff);
	}
	
	/**
	 * Get PDP current draw
	 */
	public double getDraw() {
		//PowerDistributionPanel panel = new PowerDistributionPanel();
		//panel.getCurrent(pdpPort);
		return Robot.panel.getCurrent(pdpPort);
	}
	
	public boolean isStrobe() {
		double draw = getDraw();
		return false; 
	}
}
