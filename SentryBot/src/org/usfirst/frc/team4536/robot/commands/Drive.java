package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

public class Drive extends CommandBase {
	
	private static double forwardThrottle, strafeThrottle, turnThrottle;
	
	double leftFrontTalonThrottle;
	double leftBackTalonThrottle;
	double rightFrontTalonThrottle;
	double rightBackTalonThrottle;
	
	public Drive() {
		requires(driveTrain);
	}
	
	public void initialize() {
		
		forwardThrottle = 0;
		strafeThrottle = 0;
		turnThrottle = 0;
		
	}
	
	/**
	 * @author Noah
	 * Drives mecanum drive with one joystick (like arcade) 
	 */
	protected void execute() {
		
		forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
    	turnThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
    	
    	//if (forwardThrottle == 0 && turnThrottle == 0) {
    		strafeThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
    		//leftFrontTalonThrottle = strafeThrottle;
        	//leftBackTalonThrottle = -strafeThrottle;
        	//rightFrontTalonThrottle = -strafeThrottle;
        	//rightBackTalonThrottle = strafeThrottle;
    	//}
    	//else {
    		//strafeThrottle = 0;
    		leftFrontTalonThrottle = forwardThrottle + turnThrottle + strafeThrottle;
        	leftBackTalonThrottle = forwardThrottle + turnThrottle - strafeThrottle;
        	rightFrontTalonThrottle = forwardThrottle - turnThrottle - strafeThrottle;
        	rightBackTalonThrottle = forwardThrottle - turnThrottle + strafeThrottle;
    	//}
    	
    	driveTrain.Drive(leftFrontTalonThrottle, rightFrontTalonThrottle, leftBackTalonThrottle, rightBackTalonThrottle);
    	
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
		
	}
}
