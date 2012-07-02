package net.minecraft.src.hacksaw.core.plugin;

import net.minecraft.src.ModLoader;
import net.minecraft.src.forge.NetworkMod;

public abstract class HacksawPlugin {
	private Class<NetworkMod> mod_clazz;
	private String plugin_name;
	private boolean loaded = false;

	public HacksawPlugin( String className, String pluginName ) {
		plugin_name = pluginName;
		mod_clazz = loadMod( className );
		if( mod_clazz == null ) {
			ModLoader.getLogger().info("[Hacksaw] Not loading "+plugin_name+" integration" );
		} else {
			ModLoader.getLogger().info("[Hacksaw] Loading "+plugin_name+" integration plugin" );
			loaded = true;
			init();
		}
	}

	private Class<NetworkMod> loadMod( String className ) {
		final Class<NetworkMod> clazz;
		try {
			clazz = Class.forName( className );
		} catch( ClassNotFoundException e ) {
		}
		return clazz;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public abstract void init() {}

}
