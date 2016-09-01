package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraSubsystem extends Subsystem{
	
	CameraServer cam;
	
	public CameraSubsystem() {
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void startCamera() {
		cam.startAutomaticCapture("cam0");
	}
	
	public void stopCamera() {
		
	}
	
}
