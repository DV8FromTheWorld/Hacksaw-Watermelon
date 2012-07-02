package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.hacksaw.core.CoreConfiguration;
import net.minecraft.src.hacksaw.core.PluginLoader;
import net.minecraft.src.hacksaw.core.RecipeRemover;

public class mod_Hacksaw extends NetworkMod {

	@Override
	public String getVersion() {
		return version();
	}
	
	public static String version() {
		return "0.0";
	}

	@Override
	public void load() {
		System.out.println("[Hacksaw] loading hacksaw "+getVersion());
		CoreConfiguration.configurationProperties();
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
