package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyroscope extends Subsystem {
	
	Gyro gyro;
	
	double angle;
	
	public Gyroscope(int channel) {
		gyro = new Gyro(channel);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public double getAngle() {
		angle = gyro.getAngle();
		if (angle > 180) {
			angle = angle - 360;
		}
		if (angle < -180) {
			angle = angle + 360;
		}
		return angle;
	}
	
	public void reset() {
		gyro.reset();
	}
}
