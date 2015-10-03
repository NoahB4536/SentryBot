package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

public class ArcadeDrive extends CommandBase {
	
	private static double forwardThrottle, turnThrottle;
	
	public ArcadeDrive() {
		requires(sixWheelDriveTrain);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		turnThrottle = 0;
		
	}
	
	public void execute() {
		
		forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
    	turnThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
    	
    	sixWheelDriveTrain.ArcadeDrive(forwardThrottle, turnThrottle);
		
	}
	
	public void end() {

    	sixWheelDriveTrain.ArcadeDrive(0, 0);
    	
	}
	
	protected void interrupted() {
		end();
    }
	
}
