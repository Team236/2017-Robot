package org.usfirst.frc.team236.robot.lib.pixy;

import org.opencv.core.Point;

public class Object {

	public double x, y;
	public double h, w;

	public Object(double x, double y, double h, double w) {
		if (x < -1 || x > 1 || y < -1 || y > 1) {
			throw new IllegalArgumentException("x and y must be between -1 and 1");
		}

		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}

	public Object(Point p, double h, double w) {
	}

}
