package net.minecraft.src.hacksaw.core.util;

import java.util.logging.Level;

	//this class creates a new level for us to use to log debug messages. (might want to change the class name :p)
public class HacksawDebugLoggerLevel extends Level{
	
	//not sure what to name the variable yet, so for now named it bob.  This is just somethign i do :P
	public static Level bob = new HacksawDebugLoggerLevel("Hacksaw-Debug", Level.FINER.intValue()+1);
	
	protected HacksawDebugLoggerLevel(String levelName, int levelValue) {
		super(levelName, levelValue);

	}
	

}
