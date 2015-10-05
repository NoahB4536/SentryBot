package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{
	
	public static UltrasonicSensorArray radar = new UltrasonicSensorArray(RobotMap.ULTRASONIC_IN, RobotMap.SERVO_PWN_CHANNEL);
	public static SixWheelDriveTrain sixWheelDriveTrain = new SixWheelDriveTrain(RobotMap.ARCADE_LEFT, RobotMap.ARCADE_RIGHT);
	
	public CommandBase() {
    }
	
    protected void initialize() {
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
