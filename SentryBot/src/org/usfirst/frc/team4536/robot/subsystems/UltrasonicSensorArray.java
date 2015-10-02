package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UltrasonicSensorArray extends Subsystem {
	
	Ultrasonic ultrasonic1;
	Servo servo;
	
	public UltrasonicSensorArray(int ultrasonicIn, int ultrasonicOut, int servoChannel) {
		
		ultrasonic1 = new Ultrasonic(ultrasonicOut, ultrasonicIn);
		servo = new Servo(servoChannel);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void Start() {
		ultrasonic1.setEnabled(true);
		servo.setPosition(.5);
	}
	
	public void Stop() {
		ultrasonic1.setEnabled(false);
		servo.setPosition(.5);
	}
	
	public double ReturnDistances() {
		double distance1;
		distance1 = ultrasonic1.getRangeInches();
		return distance1;
		
	}
	
}
