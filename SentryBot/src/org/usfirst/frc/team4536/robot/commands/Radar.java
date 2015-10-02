package org.usfirst.frc.team4536.robot.commands;

public class Radar extends CommandBase {
	
	public Radar() {
		requires(radar);
	}
	
	public void initialize() {
		
	}
	
	public void execute() {
		
		radar.Start();
		System.out.println(radar.ReturnDistances() * 8);
		
	}
	
}
