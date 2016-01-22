package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyroscope extends Subsystem {
	
	AnalogGyro gyro;
	
	double angle;
	
	public Gyroscope(int channel) {
		gyro = new AnalogGyro(channel);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public double getAngle() {
		angle = gyro.getAngle();
		while (angle > 180) {
			angle = angle - 360;
		}
		while (angle < -180) {
			angle = angle + 360;
		}
		return angle;
	}
	
	public void reset() {
		gyro.reset();
	}
}
