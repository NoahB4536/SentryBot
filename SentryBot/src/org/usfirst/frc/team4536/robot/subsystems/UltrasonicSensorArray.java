package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UltrasonicSensorArray extends Subsystem {
	
	AnalogInput rangefinder;
	Servo botServo;
	Servo topServo;
	
	double scanDist;
	
	public UltrasonicSensorArray(int analogIn, int servoBotChannel, int servoTopChannel) {
		
		rangefinder = new AnalogInput(analogIn);
		botServo = new Servo(servoBotChannel);
		botServo = new Servo(servoTopChannel);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public double RunScan(int topPos, int botPos) {
		topServo.setPosition(topPos / 180);
		botServo.setPosition(botPos / 180);
		scanDist = ReturnDistance();
		return scanDist;
	}
	
	public void StopScan() {
		topServo.setPosition(.5);
		botServo.setPosition(.5);
	}
	
	public double ReturnDistance() {
		double distance1 = rangefinder.getValue() / Constants.ANALOG_TO_FEET;
		return distance1;
	}
	
}
