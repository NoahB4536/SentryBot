package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.commands.*;

public class DriveUntilObject extends CommandBase {
	
	private static double forwardThrottle, turnThrottle;
	
	public DriveUntilObject() {
		requires(sixWheelDriveTrain);
		requires(radar);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		turnThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Drives forward until less than 3 feet away from an object
	 */
	public void execute() {
		
		forwardThrottle = .25;
		turnThrottle = 0;
		sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		System.out.println(radar.ReturnLeftDistance() + " " + radar.ReturnRightDistance());
		
	}
	
	protected boolean isFinished() {
		if (radar.ReturnLeftDistance() < 3) {
			return true;
		}
		else if (radar.ReturnRightDistance() < 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void end() {
		sixWheelDriveTrain.ArcadeDrive(0, 0);
	}
	
	protected void interrupted() {
		end();
    }
	
}
