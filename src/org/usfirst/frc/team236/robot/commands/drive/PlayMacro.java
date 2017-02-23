package org.usfirst.frc.team236.robot.commands.drive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PlayMacro extends Command {

	String filename;
	Scanner scanner;
	ArrayList<double[]> speedList;
	int i = 0;
	boolean isFinished = false;

	/**
	 * Create a new macro by driving
	 *
	 * @param _filename The filename, without path
	 * @throws FileNotFoundException 
	 */
	public PlayMacro(String _filename) {
		this.filename = "/home/lvuser/macros/" + _filename + ".csv";

		try {
			this.scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Bad filename");
		}

		// Extract speeds
		while (scanner.hasNextDouble()) {
			speedList.add(new double[] { scanner.nextDouble(), scanner.nextDouble() });
		}
	}

	@Override
	protected void initialize() {
		Robot.tank.stop();

		System.out.println("Playing macro from " + filename);
	}

	@Override
	protected void execute() {
		Robot.tank.setLeftSpeed(speedList.get(i)[0]);
		Robot.tank.setRightSpeed(speedList.get(i)[1]);

		System.out.println(speedList.get(i)[0] + "\t" + speedList.get(i)[1]);

		i++;
		if (i >= speedList.size()) {
			isFinished = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Robot.tank.stop();
		scanner.close();
		System.out.println("Finished macro " + filename);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
