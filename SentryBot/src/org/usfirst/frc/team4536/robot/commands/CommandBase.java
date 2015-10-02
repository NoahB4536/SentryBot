package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command{
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_FRONT_MOTOR, RobotMap.RIGHT_FRONT_MOTOR, RobotMap.LEFT_BACK_MOTOR, RobotMap.RIGHT_BACK_MOTOR);
	public static UltrasonicSensorArray radar = new UltrasonicSensorArray(RobotMap.ULTRASONIC_IN, RobotMap.SERVO_PWN_CHANNEL);
	
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
