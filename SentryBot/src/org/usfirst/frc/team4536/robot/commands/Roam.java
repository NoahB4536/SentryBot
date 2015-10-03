package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Roam extends CommandGroup {
	
	public Roam() {
		addSequential(new DriveUntilObject());
		addSequential(new TurnIfBlocked());
	}
	
}
