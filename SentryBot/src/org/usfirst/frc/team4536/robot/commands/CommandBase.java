package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_FRONT_MOTOR, RobotMap.RIGHT_FRONT_MOTOR, RobotMap.LEFT_BACK_MOTOR, RobotMap.RIGHT_BACK_MOTOR);
	public static UltrasonicSensorArray radar = new UltrasonicSensorArray(RobotMap.ULTRASONIC_IN, RobotMap.TOP_SERVO_PWM_CHANNEL, RobotMap.BOT_SERVO_PWM_CHANNEL);
	public static Gyroscope gyroBot = new Gyroscope(RobotMap.GYRO_CHANNEL_BOT);
	public static Gyroscope gyroTop = new Gyroscope(RobotMap.GYRO_CHANNEL_TOP);
	public static USBCam camera = new USBCam();
	
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
