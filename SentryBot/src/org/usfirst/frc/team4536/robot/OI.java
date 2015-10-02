package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4536.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static boolean strafing;
    
	public static Button strafe;
	
	public static Joystick mainStick;
	
	public OI() {
		
		mainStick = new Joystick(RobotMap.MAIN_STICK);
		
		strafe = new JoystickButton(mainStick, 2);
		
		strafing = mainStick.getRawButton(2);
		
	}
	
}

