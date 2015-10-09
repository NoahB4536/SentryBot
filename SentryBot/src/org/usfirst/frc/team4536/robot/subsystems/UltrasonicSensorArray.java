package org.usfirst.frc.team4536.robot.subsystems;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UltrasonicSensorArray extends Subsystem {
	
	AnalogInput rangefinder;
	Servo servo;
	
	public TableModel radarTable;
	
	public UltrasonicSensorArray(int analogIn, int servoChannel) {
		
		rangefinder = new AnalogInput(analogIn);
		servo = new Servo(servoChannel);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void Start() {
		servo.setPosition(.5);
	}
	
	public void Stop() {
		servo.setPosition(.5);
	}
	
	public double ReturnDistances() {
		double distance1 = rangefinder.getValue() / (Constants.ANALOG_TO_FEET * 0.3917);
		return distance1;
	}
	
}
