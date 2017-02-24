package org.usfirst.frc.team236.robot.lib.pixy;

public interface Pixy {

	public enum Coordinate {
		X, Y
	}

	public double getX();

	public double getY();

	public boolean isObjectFound();

}
