package hacksaw.core.util;

import java.util.logging.Level;

import net.minecraft.src.ModLoader;

	//this class creates a new level for us to use to log debug messages. (might want to change the class name :p)
public class HacksawDebugLoggerLevel extends Level{
	
	//not sure what to name the variable yet, so for now named it bob.  This is just somethign i do :P
	public static Level bob = new HacksawDebugLoggerLevel("Hacksaw-Debug", Level.FINER.intValue()+1);
	
	protected HacksawDebugLoggerLevel(String levelName, int levelValue) {
		super(levelName, levelValue);

	}
	
	public class LogLevel {
		public static final int INFO = 0;
		public static final int FINE = 1;
		public static final int WARNING = 2;
		public static final int DEBUG = 3;
		public static final int SEVERE = 4;
		
	}
	
	public static void log(String logText) {
		log(logText, LogLevel.INFO);
	}
	
	public static void log(String logText, int level) {
		switch (level) {
		case LogLevel.FINE:
			ModLoader.getLogger().fine("[Hacksaw] " + logText);
			break;
		case LogLevel.INFO:
			ModLoader.getLogger().info("[Hacksaw] " + logText);
			break;
		case LogLevel.WARNING:
			ModLoader.getLogger().warning("[Hacksaw] " + logText);
			break;
		case LogLevel.SEVERE:
			ModLoader.getLogger().severe("[Hacksaw] " + logText);
		}
	}

}
