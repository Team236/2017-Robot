package org.usfirst.frc.team236.robot.lib;

import org.usfirst.frc.team236.robot.Robot;

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

	public void cycle(int n) {
		try {
			for (int i = 0; i < n; i++) {
				on();
				Thread.sleep(10);
				off();
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void safeOn() {
		cycle(2);
		on();
	}

	/**
	 * Get PDP current draw
	 */
	@Deprecated
	public double getDraw() {
		//PowerDistributionPanel panel = new PowerDistributionPanel();
		//panel.getCurrent(pdpPort);
		return Robot.panel.getCurrent(pdpPort);
	}

	@Deprecated
	public boolean isStrobe() {
		return false;
	}
}
