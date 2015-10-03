package org.usfirst.frc.team4536.robot.commands;

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
	
	public void execute() {
		
		forwardThrottle = .25;
		turnThrottle = 0;
		sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		System.out.println(radar.ReturnDistances());
		
	}
	
	protected boolean isFinished() {
		return radar.ReturnDistances() < 2;
	}
	
	public void end() {
		sixWheelDriveTrain.ArcadeDrive(0, 0);
	}
	
	protected void interrupted() {
		end();
    }
	
}
