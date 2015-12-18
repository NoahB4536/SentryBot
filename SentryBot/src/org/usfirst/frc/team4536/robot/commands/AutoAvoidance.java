package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

public class AutoAvoidance extends CommandBase {
	
	private static double forwardThrottle, strafeThrottle, turnThrottle;
	
	double leftFrontTalonThrottle;
	double leftBackTalonThrottle;
	double rightFrontTalonThrottle;
	double rightBackTalonThrottle;
	
	double botVal;
	double topVal;
	
	double dist;
	
	boolean positive;
	
	double angleTop;
	double angleBase;
	double angleFinal;
	
	public AutoAvoidance() {
		requires(gyro);
		requires(gyro2);
		requires(driveTrain);
		requires(radar);
	}
	
	public void initialize() {
		topVal = 90;
		botVal = 90;
		radar.RunScan(topVal, botVal);
		gyro.reset();
		gyro2.reset();
		positive = true;
		forwardThrottle = 0;
		strafeThrottle = 0;
		turnThrottle = 0;
	}
	
	public void execute() {
		angleBase = gyro.getAngle();
		//System.out.println(angleBase);
		angleBase = gyro.getAngle();
		//System.out.println(angleBase2);
		if (angleBase < 0) {
			angleBase = angleBase * -1;
		}
		angleFinal = angleTop - angleBase;
		while (angleFinal > 180) {
			angleFinal = angleFinal - 360;
		}
		while (angleBase < -180) {
			angleFinal = angleFinal + 360;
		}
		System.out.println(angleFinal);
		
		if (positive == true) {
			topVal = topVal + 1;
			botVal = botVal + 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println("      " + dist);
			if (topVal == 180) {
				positive = false;
			}
		}
		else if (positive == false) {
			topVal = topVal - 1;
			botVal = botVal - 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println("      " + dist);
			if (topVal == 0) {
				positive = true;
			}
		}
		
		if (dist <= 1) {
			if (angleFinal <= 22.5 && angleFinal > -22.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) > 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= 67.5 && angleFinal > 22.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) > 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) > 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= 112.5 && angleFinal > 67.5) {
				forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) > 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= 157.5 && angleFinal > 112.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) < 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) > 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= -157.5 && angleFinal > 157.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) < 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= -112.5 && angleFinal > -157.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) < 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) < 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= -67.5 && angleFinal > -112.5) {
				forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) < 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
			else if (angleFinal <= -22.5 && angleFinal > -67.5) {
				if (Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE) > 0) {
					forwardThrottle = 0;
				}
				else {
					forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
				}
				if (Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE) < 0) {
					strafeThrottle = 0;
				}
				else {
					strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
				}
	    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
			}
		}
		else {
		
			forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
			strafeThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
    		turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
    	
		}
    	
    	leftFrontTalonThrottle = forwardThrottle + turnThrottle + strafeThrottle;
        leftBackTalonThrottle = forwardThrottle + turnThrottle - strafeThrottle;
        rightFrontTalonThrottle = forwardThrottle - turnThrottle - strafeThrottle;
        rightBackTalonThrottle = forwardThrottle - turnThrottle + strafeThrottle;
    	
    	driveTrain.drive(leftFrontTalonThrottle, rightFrontTalonThrottle, leftBackTalonThrottle, rightBackTalonThrottle);
	}
	
	protected boolean isFinished() {
        return false;
    }
	
	protected void interrupted() {
		System.out.println("interrupted");
		radar.RunScan(90, 90);
		end();
    }
	
	protected void end() {
	}
	
}
