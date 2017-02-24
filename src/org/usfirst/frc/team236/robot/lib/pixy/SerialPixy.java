package org.usfirst.frc.team236.robot.lib.pixy;

import java.awt.Point;

public interface SerialPixy {

	public enum Coordinate {
		X, Y
	}

	public Point getPoint();

	public double getX();

	public double getY();

	public boolean isObjectFound();

}
