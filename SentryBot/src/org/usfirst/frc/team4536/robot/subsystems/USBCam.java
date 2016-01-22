package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class USBCam extends Subsystem {
	
	//USBCamera cam;
	
	CameraServer camServer;
	
	String camName = "cam0";
	
	protected void initDefaultCommand() {
	}
	
	public USBCam() {
		//cam = new USBCamera(camName);
	}
	
	public void Start() {
		//cam.openCamera();
		//cam.startCapture();
		camServer = CameraServer.getInstance();
		camServer.setQuality(50);
		camServer.startAutomaticCapture(camName);
	}
	
	public void Stop() {
		//cam.stopCapture();
		//cam.closeCamera();
	}
	
}
