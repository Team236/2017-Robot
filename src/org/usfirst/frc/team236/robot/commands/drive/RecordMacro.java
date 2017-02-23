package org.usfirst.frc.team236.robot.commands.drive;

import java.io.FileWriter;
import java.io.IOException;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RecordMacro extends Command {

	FileWriter writer;
	String filename;

	/**
	 * Create a new macro by driving
	 *
	 * @param _filename The filename, without path
	 */
	public RecordMacro(String _filename) {
		this.filename = "/home/lvuser/macros/" + _filename + ".csv";
	}

	@Override
	protected void initialize() {
		Robot.tank.stop();

		// Get ready to write file
		try {
			writer = new FileWriter(filename, false);
			System.out.println("File created: recording macro to " + filename);
		} catch (IOException e) {
			System.out.println("File creation failed");
		}
	}

	@Override
	protected void execute() {
		// Pass joystick input through
		double leftSpeed = -Robot.oi.left.getY();
		double rightSpeed = -Robot.oi.right.getY();

		Robot.tank.setLeftSpeed(leftSpeed);
		Robot.tank.setRightSpeed(rightSpeed);

		try {
			writer.append(leftSpeed + " " + rightSpeed + "\n");
			System.out.print(leftSpeed + " " + rightSpeed + "\n");
		} catch (IOException e) {
			System.out.println("File writing failed");
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.tank.stop();
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Writer cleaning failed");
		}
	}

	@Override
	protected void interrupted() {
		end();
	}
}
