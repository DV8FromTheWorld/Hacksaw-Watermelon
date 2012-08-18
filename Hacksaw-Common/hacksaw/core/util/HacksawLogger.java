package hacksaw.core.util;

import hacksaw.core.HacksawItems;

import java.util.logging.Level;

import cpw.mods.fml.common.Loader;

import net.minecraft.src.ModLoader;

public class HacksawLogger extends Level{
	
	public static Level HS_DEBUG = new HacksawLogger("Hacksaw-Debug", Level.FINE.intValue()+1);
	
	protected HacksawLogger(String levelName, int levelValue) {
		super(levelName, levelValue);

	}
	
	public static void checkDebugSetting(){

		if(CoreConfiguration.getPreference(CoreConfiguration.ENABLE_DEBUG) == true){
			Level k;
			k = Loader.log.getLevel();
			System.out.println(String.valueOf(k));
			Loader.log.setLevel(Level.FINER);
			k = ModLoader.getLogger().getLevel();
			System.out.println(String.valueOf(k));
			ModLoader.getLogger().finer("yo!");
			System.out.println("yo!");
		}
	}
	
	public class LogLevel {
		public static final int INFO = 0;
		public static final int FINE = 1;
		public static final int WARNING = 2;
		public static final int DEBUG = 3;
		public static final int SEVERE = 4;
		
	}
	
	public static void log(String logText) {
		log(LogLevel.INFO, logText);
	}
	
	public static void log(int level, String logText) {
		switch (level) {
		case LogLevel.INFO:
			ModLoader.getLogger().info("[Hacksaw] " + logText);
			break;
		case LogLevel.FINE:
			ModLoader.getLogger().fine("[Hacksaw] " + logText);
			break;
		case LogLevel.WARNING:
			ModLoader.getLogger().warning("[Hacksaw] " + logText);
			break;
		case LogLevel.SEVERE:
			ModLoader.getLogger().severe("[Hacksaw] " + logText);
			break;
		case LogLevel.DEBUG:
			ModLoader.getLogger().log(HacksawLogger.HS_DEBUG, " [Hacksaw-Debug] " + logText);			
		}
	}
}
