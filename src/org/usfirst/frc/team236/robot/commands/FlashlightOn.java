package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlashlightOn extends Command {

    public FlashlightOn() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.garage.lightOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.garage.lightOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.garage.lightOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
