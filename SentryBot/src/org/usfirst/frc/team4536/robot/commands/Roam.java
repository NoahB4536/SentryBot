package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Roam extends CommandGroup {
	
	public Roam() {
		
		System.out.println("Driving");
		addSequential(new DriveUntilObject());
		System.out.println("Turning");
		addSequential(new TurnIfBlocked());
		System.out.println("Done");
		
	}
	
}
