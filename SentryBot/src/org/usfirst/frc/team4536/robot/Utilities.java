package org.usfirst.frc.team4536.robot;

public class Utilities {
	
	public static double deadZone(double input, double deadZone){
		
		if((input > -deadZone) && (input < deadZone)) 
			return 0;
		else
			return input;
	}
	
}
