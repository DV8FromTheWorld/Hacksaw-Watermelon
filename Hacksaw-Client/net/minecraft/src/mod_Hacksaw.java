package net.minecraft.src;

import java.io.File;

import hacksaw.core.HacksawCore;
import hacksaw.core.PluginLoader;
import hacksaw.core.RecipeRemover;
import hacksaw.core.util.Register;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.HacksawLogger.LogLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.src.mod_Hacksaw;

import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;

public class mod_Hacksaw extends NetworkMod {
		
	//CLIENT SIDE
	public static boolean initialized = false;
	public static File path = Minecraft.getMinecraftDir();
	
	@Override
	public String getVersion() {
		return CoreConfiguration.getVersion();
	}
	
	@Override
	public String getName() {
		return CoreConfiguration.getName();
	}

	@Override
	public void load() {
		if(!mod_Hacksaw.initialized && !ModLoader.isModLoaded("mod_Hacksaw")){
			HacksawLogger.log("Loading Hacksaw-Watermelon...");
			preloadTextures();
			HacksawCore.init();
			HacksawLogger.log("Hacksaw-Watermelon has successfully loaded");
		}else{
			HacksawLogger.log( LogLevel.SEVERE, "Hacksaw-Watermelon is already loaded, check for a duplicate Hacksaw-Watermlon installed");
		}
	}
	
	public void preloadTextures(){
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/items.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/food.png");
	}
	
	public void modsLoaded(){
		CraftingStuff.init();
	}

	public boolean clientSideRequired() {
		return true;
	}

	public boolean serverSideRequired() {
		return false;
	}
	
}
