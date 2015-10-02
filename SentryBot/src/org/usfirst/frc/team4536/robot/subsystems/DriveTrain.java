package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	Talon leftFrontTalon;
	Talon rightFrontTalon;
	Talon leftBackTalon;
	Talon rightBackTalon;
	
	public static double prevForwardThrottle = 0.0, prevStrafeThrottle = 0.0;
	
	public DriveTrain(int leftFrontTalonChannel, int rightFrontTalonChannel, int leftBackTalonChannel, int rightBackTalonChannel) {
		
		leftFrontTalon = new Talon(leftFrontTalonChannel);
		rightFrontTalon = new Talon(rightFrontTalonChannel);
		leftBackTalon = new Talon(leftBackTalonChannel);
		rightBackTalon = new Talon(rightBackTalonChannel);
		
    	leftFrontTalon.set(0.0);
    	rightFrontTalon.set(0.0);
    	leftBackTalon.set(0.0);
    	rightBackTalon.set(0.0);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void Drive(double leftFrontTalonThrottle, double rightFrontTalonThrottle, double leftBackTalonThrottle, double rightBackTalonThrottle) {
		
    	leftFrontTalon.set(leftFrontTalonThrottle);
    	rightFrontTalon.set(rightFrontTalonThrottle);
    	leftBackTalon.set(leftBackTalonThrottle);
    	rightBackTalon.set(rightBackTalonThrottle);
    	
	}
}
