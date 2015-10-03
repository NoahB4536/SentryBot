package org.usfirst.frc.team4536.robot.commands;

public class TurnIfBlocked extends CommandBase {
	
private static double forwardThrottle, turnThrottle;
	
	public TurnIfBlocked() {
		requires(sixWheelDriveTrain);
		requires(radar);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		turnThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Turns right away from an object
	 */
	public void execute() {
		
		forwardThrottle = 0;
		turnThrottle = .5;
		sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		System.out.println(radar.ReturnDistances());
		
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
