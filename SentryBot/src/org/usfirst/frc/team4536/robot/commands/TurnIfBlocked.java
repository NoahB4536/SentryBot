package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

public class TurnIfBlocked extends CommandBase {
	
	private static double turnThrottle;
	
	public TurnIfBlocked() {
		requires(sixWheelDriveTrain);
		requires(radar);
	}
	
	public void initialize() {
		
		turnThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Turns away from an object
	 */
	public void execute() {
		
		if (radar.ReturnRightDistance() > radar.ReturnLeftDistance()) {
			if (radar.ReturnRightDistance() < 2.5) {
				turnThrottle = -.35;
			}
			else {
			turnThrottle = .35;
			}
		}
		else if (radar.ReturnLeftDistance() > radar.ReturnRightDistance()) {
			turnThrottle = -.35;
		}
		else {
			turnThrottle = 0;
		}
		
		sixWheelDriveTrain.ArcadeDrive(0, turnThrottle);
		System.out.println(radar.ReturnLeftDistance() + " " + radar.ReturnRightDistance());
		
	}
	
	protected boolean isFinished() {
		if (radar.ReturnLeftDistance() > Constants.DRIVE_DIST) {
			if (radar.ReturnRightDistance() > Constants.DRIVE_DIST) {
				return true;
			}
			else {
				return false;
			}
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
