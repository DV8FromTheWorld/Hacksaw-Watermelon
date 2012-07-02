package net.minecraft.src.hacksaw.core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.hacksaw.core.plugins.*;
import net.minecraft.src.ModLoader;

public enum PluginLoader {
	INSTANCE;

	protected Map<String,HacksawPlugin> plugins;

	private PluginLoader() {
		plugins = new HashMap<String,HacksawPlugin>();
	}

	public static void checkPlugins() {
		ModLoader.getLogger().info( "[Hacksaw] PluginLoader scanning for integration plugins..." );

		addPlugin( "IC2", new Plugin_IC2("mod_IC2", "IC2") );
		addPlugin( "EE", new Plugin_EE("mod_EE", "EquivalentExchange") );
		addPlugin( "ThaumCraft", new Plugin_ThaumCraft("mod_ThaumCraft", "ThaumCraft") );

		final int numPlugins = INSTANCE.plugins.size();
		ModLoader.getLogger().info( "[Hacksaw] PluginLoader has checked "+numPlugins+" plugins." );
	}

	private static void addPlugin( String pluginName, HacksawPlugin plugin ) {
		INSTANCE.plugins.put( pluginName, plugin );
	}

	public static HacksawPlugin getPlugin( String pluginName ) {
		return INSTANCE.plugins.get( pluginName );
	}
	public static boolean pluginLoaded( String pluginName ) {
		final HacksawPlugin plugin = getPlugin( pluginName );
		if( plugin != null ) {
			return plugin.isLoaded();
		}
		return false;
	}
	
}
