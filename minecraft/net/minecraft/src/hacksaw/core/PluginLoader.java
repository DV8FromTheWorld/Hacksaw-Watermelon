package net.minecraft.src.hacksaw.core;

import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.ModLoader;

public class PluginLoader {
	private static Class<NetworkMod> mod_IC2 = null;
	private static Class<NetworkMod> mod_EE = null;
	private static Class<NetworkMod> mod_ThaumCraft = null;
	
	public static void loadPlugins(){
		loadIC2();
		loadEE();
		loadThaumCraft();
	}

	private static Class<NetworkMod> loadMod( String className ) {
		//ModLoader.getLogger().info( "[Hacksaw] Looking for "+className );
		final Class<NetworkMod> clazz;
		try {
			clazz = Class.forName( className );
		} catch( ClassNotFoundException e ) {
		}
		return clazz;
	}

	private static void loadIC2() {
		mod_IC2 = loadMod( "mod_IC2" );
		if( gotIC2() ) {
			// TODO: load IC2 integration
			ModLoader.getLogger().info( "[Hacksaw] Loading IC2 integration plugin" );
		} else {
			ModLoader.getLogger().info( "[Hacksaw] Not loading IC2 integration" );
		}
	}
	public static boolean gotIC2() {
		return mod_IC2 != null;
	}

	private static void loadEE() {
		mod_EE = loadMod( "mod_EE" );
		if( gotEE() ) {
			// TODO: load Equivalent Exchange integration
			ModLoader.getLogger().info( "[Hacksaw] Loading Equivalent Exchange integration plugin" );
		} else {
			ModLoader.getLogger().info( "[Hacksaw] Not loading Equivalent Exchange integration" );
		}
	}
	public static boolean gotEE() {
		return mod_EE != null;
	}

	private static void loadThaumCraft() {
		mod_ThaumCraft = loadMod( "mod_ThaumCraft" );
		if( gotThaumCraft() ) {
			// TODO: load ThaumCraft integration
			ModLoader.getLogger().info( "[Hacksaw] Loading ThaumCraft integration plugin" );
		} else {
			ModLoader.getLogger().info( "[Hacksaw] Not loading ThaumCraft integration" );
		}
	}
	public static boolean gotThaumCraft() {
		return mod_ThaumCraft != null;
	}
	
}
