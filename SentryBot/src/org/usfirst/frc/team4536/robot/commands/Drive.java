package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

public class Drive extends CommandBase {
	
	private static double forwardThrottle, strafeThrottle;
	
	public Drive() {
		requires(driveTrain);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		strafeThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Drives mecanum drive with one joystick (like arcade) 
	 */
	protected void execute() {
		
		forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
    	strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
		
    	if (strafeThrottle < 0) {
    		strafeThrottle = -strafeThrottle;
    	}
    	
    	double leftFrontTalonThrottle = forwardThrottle + strafeThrottle;
    	double rightFrontTalonThrottle = forwardThrottle - strafeThrottle;
    	double leftBackTalonThrottle = forwardThrottle - strafeThrottle;
    	double rightBackTalonThrottle = forwardThrottle + strafeThrottle;
    	
    	driveTrain.Drive(leftFrontTalonThrottle, rightFrontTalonThrottle, leftBackTalonThrottle, rightBackTalonThrottle);
    	
	}
	
	protected void interrupted() {
		end();
    }
}
