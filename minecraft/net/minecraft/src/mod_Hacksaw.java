package net.minecraft.src;

import hacksaw.core.PluginLoader;
import hacksaw.core.RecipeRemover;
import hacksaw.core.Register;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;
import net.minecraft.client.Minecraft;
import net.minecraft.src.mod_Hacksaw;

import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;

public class mod_Hacksaw extends NetworkMod {

	//CLIENT SIDE
	public static boolean initialized = false;
	
	@Override
	public String getVersion() {
		return version();
	}
	
	@Override
	public String getName() {
		return "Hacksaw Watermelon";
	}
	
	public static String version() {
		return "0.1";
	}

	@Override
	public void load() {
		if(!mod_Hacksaw.initialized && !ModLoader.isModLoaded("mod_Hacksaw")){
			preloadTextures();
			CoreConfiguration.init(Minecraft.getMinecraftDir(), "config/hacksaw/core.cfg");
			Register.registerItemsAndBlocksAndRecipes();
			PluginLoader.checkPlugins();
			RecipeRemover.removeVanillaRecipes();
			mod_Hacksaw.initialized = true;
			ModLoader.getLogger().info("[Hacksaw] Hacksaw-Watermelon has successfully loaded");
		}else{
			ModLoader.getLogger().severe("[Hacksaw] Hacksaw-Watermelon is already loaded, check for a duplicate Hacksaw-Watermlon installed");
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
