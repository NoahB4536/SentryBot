package org.usfirst.frc.team4536.robot.commands;

public class TurnIfBlocked extends CommandBase {
	
private static double forwardThrottle, turnThrottle;
boolean turnDirection;
	
	public TurnIfBlocked() {
		requires(sixWheelDriveTrain);
		requires(radar);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		turnThrottle = 0;
		turnDirection = true;
		
	}
	
	/**
	 * @author Noah
	 * Turns away from an object
	 */
	public void execute() {
		
		if (radar.ReturnRightDistance() > radar.ReturnLeftDistance()) {
			turnDirection = true;
		}
		else if (radar.ReturnLeftDistance() > radar.ReturnRightDistance()) {
			turnDirection = false;
		}
		forwardThrottle = 0;
		if (turnDirection = true) {
			turnThrottle = .35;
		}
		else if (turnDirection = false) {
			turnThrottle = -.35;
		}
		sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		System.out.println(radar.ReturnLeftDistance() + " " + radar.ReturnRightDistance());
		
	}
	
	protected boolean isFinished() {
		if (radar.ReturnLeftDistance() > 4) {
			if (radar.ReturnRightDistance() > 4) {
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
