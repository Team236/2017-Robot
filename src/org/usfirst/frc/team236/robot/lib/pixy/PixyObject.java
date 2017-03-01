package org.usfirst.frc.team236.robot.lib.pixy;

import org.opencv.core.Point;

public class PixyObject {

	public double x, y;
	public double h, w;

	public PixyObject(double x, double y, double h, double w) {
		if (x < -1 || x > 1 || y < -1 || y > 1) {
			throw new IllegalArgumentException("x and y must be between -1 and 1");
		}

		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}
	
	public PixyObject(Point p, double h, double w) {
		this(p.x, p.y, h, w);
	}

	public Point getCenter() {
		return new Point(this.x, this.y);
	}
	
	/**
	 * Determine if a PixyObject obj is identical to this one
	 * 
	 * @param obj The PixyObject to compare
	 * @return whether the two are equal
	 */
	public boolean equals(PixyObject obj) {
		return (obj.getCenter().equals(this.getCenter())) && (obj.h == this.h && obj.w == this.w);
	}

}
