package org.usfirst.frc.team236.robot.commands.drive;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private double kP;
	private double speed;
	private double dist;

	// Collision detection
	double lastAccel, currAccel;
	double jerk;
	public static final double collisionThreshold = 1; //TODO Set collision threshold

	int i = 0;

	/**
	 * @param _kP The proportional feedback constant
	 * @param _dist The distance to drive
	 */
	public DriveStraight(double _kP, double _dist, double _speed) {
		this.kP = _kP;
		this.dist = _dist;
		this.speed = _speed;
		requires(Robot.tank);
	}

	public DriveStraight(double _dist) {
		this(-0.10, _dist, -0.4); // Construct with default values
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.tank.zeroEncoders();
		Robot.tank.navx.reset();
		i = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		i++;

		double ang = Robot.tank.navx.getAngle();

		double leftSpeed = speed;
		double rightSpeed = speed;

		leftSpeed += ang * kP;
		rightSpeed -= ang * kP;

		Robot.tank.setSpeeds(leftSpeed, rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// Stop command if both encoders have gone the distance
		if (Math.abs(Robot.tank.getLeftEncoder().getDistance() - dist) < 1 && Math.abs(Robot.tank.getRightEncoder().getDistance() - dist) < 1) {
			return true;
		}

		return (i / 50 > 5);
	}

	@Override
	protected void end() {
		Robot.tank.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
