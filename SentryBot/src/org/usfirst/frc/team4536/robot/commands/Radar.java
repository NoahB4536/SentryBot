package org.usfirst.frc.team4536.robot.commands;

public class Radar extends CommandBase {
	
	int botVal;
	int topVal;
	int prevTopVal;
	
	double dist;
	
	boolean goingRight;
	
	public Radar() {
		requires(radar);
	}
	
	public void initialize() {
		topVal = 90;
		botVal = 90;
	}
	
	public void execute() {
		
		if (topVal <= 180 && topVal > prevTopVal) {
			prevTopVal = topVal;
			topVal = topVal + 1;
			botVal = botVal + 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
		}
		else if (topVal > prevTopVal) {
			prevTopVal = topVal;
			topVal = topVal - 1;
			botVal = botVal - 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
		}
		if (topVal >= 0 && topVal < prevTopVal) {
			prevTopVal = topVal;
			topVal = topVal - 1;
			botVal = botVal - 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
		}
		else if (topVal < prevTopVal) {
			prevTopVal = topVal;
			topVal = topVal + 1;
			botVal = botVal + 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
		}
		
		System.out.println(radar.ReturnDistance());
		
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
		radar.StopScan();
	}
	
}
