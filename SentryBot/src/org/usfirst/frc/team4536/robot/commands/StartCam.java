package org.usfirst.frc.team4536.robot.commands;

public class StartCam extends CommandBase {
	
	public StartCam() {
		requires(camera);
	}
	
	protected void initialize() {
    }
    
    protected void execute() {
    	camera.startCamera();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
