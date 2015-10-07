package org.usfirst.frc.team4536.robot.commands;

public class Radar extends CommandBase {
	
	public Radar() {
		requires(radar);
	}
	
	public void initialize() {
		
	}
	
	/**
	 * @author Noah
	 * Prints the distance value from the ultrasonic to the Riolog
	 */
	public void execute() {
		
		radar.Start();
		System.out.println(radar.ReturnLeftDistance());
		
	}
	
	protected void interrupted() {
		end();
    }
	
}
