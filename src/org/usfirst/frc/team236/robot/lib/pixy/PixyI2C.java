package org.usfirst.frc.team236.robot.lib.pixy;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Interfaces with a pixy in analog mode.
 * TODO Finish serial pixy implementation
 * @author samcf
 */
public class PixyI2C implements Pixy {

	public Coordinate coord;
	private DigitalInput foundInput;
	private AnalogInput dataInput;

	public PixyI2C(int foundChannel, int dataChannel, Coordinate _coord) {
		this.coord = _coord;

		// Create wpilib inputs
		this.dataInput = new AnalogInput(dataChannel);
		this.foundInput = new DigitalInput(foundChannel);
	}

	@Override
	public double getX() {
		if (this.coord == Coordinate.X) {
			return dataInput.getVoltage() / 3.3;
		}
		return -1;
	}

	@Override
	public double getY() {
		if (this.coord == Coordinate.Y) {
			return dataInput.getVoltage() / 3.3;
		}
		return -1;
	}

	@Override
	public boolean isObjectFound() {
		return foundInput.get();
	}

}
