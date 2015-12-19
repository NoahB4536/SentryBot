package org.usfirst.frc.team4536.robot.commands;

public class RunGyro extends CommandBase {
	
	double angle;
	
	public RunGyro() {
		requires(gyroBot);
	}
	
	public void initialize() {
		gyroBot.reset();
	}
	
	public void execute() {
		angle = gyroBot.getAngle();
		System.out.println(angle);
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
	}
}
