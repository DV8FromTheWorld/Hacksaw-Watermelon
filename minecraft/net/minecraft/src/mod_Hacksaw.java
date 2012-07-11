package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.hacksaw.core.PluginLoader;
import net.minecraft.src.hacksaw.core.RecipeRemover;
import net.minecraft.src.hacksaw.core.util.CoreConfiguration;

public class mod_Hacksaw extends NetworkMod {

	@Override
	public String getVersion() {
		return version();
	}
	
	@Override
	public String getName() {
		return "Hacksaw Watermelon";
	}
	
	public static String version() {
		return "0.0.1";
	}

	@Override
	public void load() {
		CoreConfiguration.init( "config/hacksaw/core.cfg" );
		PluginLoader.checkPlugins();
		RecipeRemover.removeVanillaRecipes();
	}

	public boolean clientSideRequired() {
		return true;
	}

	public boolean serverSideRequired() {
		return false;
	}
	
}
