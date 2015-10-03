package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SixWheelDriveTrain extends Subsystem {
	
	Talon leftTalon;
	Talon rightTalon;
	
	public SixWheelDriveTrain(int leftTalonChannel,int rightTalonChannel) {
		
		leftTalon = new Talon(leftTalonChannel);
		rightTalon = new Talon(rightTalonChannel);
		
		leftTalon.set(0);
		rightTalon.set(0);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void ArcadeDrive(double forwardThrottle, double turnThrottle) {
		
		double leftTalonThrottle = forwardThrottle + turnThrottle;
    	double rightTalonThrottle = forwardThrottle - turnThrottle;
    	
    	leftTalon.set(leftTalonThrottle);
    	rightTalon.set(-rightTalonThrottle);
		
	}
	
}