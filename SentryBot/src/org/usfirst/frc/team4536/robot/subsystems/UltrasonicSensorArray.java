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
		topServo = new Servo(servoBotChannel);
		botServo = new Servo(servoTopChannel);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public double RunScan(double topPos, double botPos) {
		topPos = topPos / 180;
		botPos = botPos / 180;
		topServo.setPosition(topPos);
		botServo.setPosition(botPos);
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
