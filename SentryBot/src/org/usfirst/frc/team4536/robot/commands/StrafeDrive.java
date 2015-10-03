package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;


public class StrafeDrive extends CommandBase {
	
private static double forwardThrottle, strafeThrottle;
	
	public StrafeDrive() {
		//requires(driveTrain);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		strafeThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Drives only left or right
	 */
	protected void execute() {
		
		forwardThrottle = 0;
    	strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
		
    	double leftFrontTalonThrottle = forwardThrottle - strafeThrottle;
    	double rightFrontTalonThrottle = forwardThrottle + strafeThrottle;
    	double leftBackTalonThrottle = forwardThrottle + strafeThrottle;
    	double rightBackTalonThrottle = forwardThrottle - strafeThrottle;
    	
    	//driveTrain.Drive(leftFrontTalonThrottle, rightFrontTalonThrottle, leftBackTalonThrottle, rightBackTalonThrottle);
    	
	}
	
	protected void interrupted() {
		end();
    }
	
}
