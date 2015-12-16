package org.usfirst.frc.team4536.robot.commands;

public class Radar extends CommandBase {
	
	double botVal;
	double topVal;
	
	double dist;
	
	boolean positive;
	
	public Radar() {
		requires(radar);
	}
	
	public void initialize() {
		topVal = 90;
		botVal = 90;
		radar.RunScan(topVal, botVal);
		positive = true;
	}
	
	public void execute() {
		
		if (positive == true) {
			topVal = topVal + 1;
			botVal = botVal + 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
			if (topVal == 180) {
				positive = false;
			}
		}
		else if (positive == false) {
			topVal = topVal - 1;
			botVal = botVal - 1;
			dist = radar.RunScan(topVal, botVal);
			System.out.println(dist);
			if (topVal == 0) {
				positive = true;
			}
		}
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
		radar.StopScan();
	}
	
}
