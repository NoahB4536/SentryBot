package org.usfirst.frc.team4536.robot.commands;

public class SetGimble extends CommandBase {
	
	public SetGimble() {
		requires(radar);
	}
	
	public void initialize() {
	}
	
	public void execute() {
		
		radar.RunScan(90, 90);
		
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
		radar.StopScan();
	}
	
}
