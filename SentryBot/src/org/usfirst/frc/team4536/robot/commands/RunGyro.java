package org.usfirst.frc.team4536.robot.commands;

public class RunGyro extends CommandBase {
	
	double angle;
	
	public RunGyro() {
		requires(gyro);
	}
	
	public void initialize() {
		gyro.reset();
	}
	
	public void execute() {
		angle = gyro.getAngle();
		System.out.println(angle);
	}
	
	protected void interrupted() {
		end();
    }
	
	protected void end() {
	}
}
