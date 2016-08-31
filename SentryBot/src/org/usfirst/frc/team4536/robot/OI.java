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
	
	public static Joystick mainStick;
	
	public static Joystick secondaryStick;
	
	public static Button slowMode;
	
	public OI() {
		
		mainStick = new Joystick(RobotMap.MAIN_STICK);
		
		secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
		
		slowMode = new JoystickButton(mainStick, 2);
		
		slowMode.whileHeld(new SlowMode());
		
	}
	
}

