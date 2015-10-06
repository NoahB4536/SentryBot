package org.usfirst.frc.team4536.robot.commands;

public class TurnIfBlocked extends CommandBase {
	
private static double forwardThrottle, turnThrottle, prevRadar;
boolean turnDirection;
	
	public TurnIfBlocked() {
		requires(sixWheelDriveTrain);
		requires(radar);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		turnThrottle = 0;
		prevRadar = 0;
		turnDirection = true;
		
	}
	
	/**
	 * @author Noah
	 * Turns right away from an object
	 */
	public void execute() {
		
		if (prevRadar > radar.ReturnDistances()) {
			if (turnDirection = true) {
				turnDirection = false;
			}
			else {
				turnDirection = true;
			}
		}
		forwardThrottle = 0;
		if (turnDirection = true) {
			turnThrottle = .4;
		}
		else if (turnDirection = false) {
			turnThrottle = -.4;
		}
		sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		System.out.println(radar.ReturnDistances());
		prevRadar = radar.ReturnDistances();
		
	}
	
	protected boolean isFinished() {
		return radar.ReturnDistances() > 4;
	}
	
	public void end() {
		sixWheelDriveTrain.ArcadeDrive(0, 0);
	}
	
	protected void interrupted() {
		end();
    }
	
}
