package org.usfirst.frc.team4536.robot.commands;

public class TestUltra extends CommandBase {
	
	public TestUltra() {
		requires(radar);
	}
	
	public void initialize() {
		radar.RunScan(90, 90);
	}
	
	public void execute() {
		System.out.println(radar.ReturnDistance());
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
		radar.StopScan();
	}
	
}
