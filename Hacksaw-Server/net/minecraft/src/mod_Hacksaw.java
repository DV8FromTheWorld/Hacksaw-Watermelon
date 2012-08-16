package net.minecraft.src;

import hacksaw.core.BlockReplacer;
import hacksaw.core.RecipeRemover;
import hacksaw.core.Register;
import hacksaw.core.PluginLoader;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;

import java.io.File;

import cpw.mods.fml.common.modloader.BaseMod;

import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.NetworkMod;

public class mod_Hacksaw extends NetworkMod {

	//SERVER SIDE
	public static boolean initialized = false;
	
	@Override
	public String getVersion() {
		return CoreConfiguration.version();
	}
	
	@Override
	public String getName() {
		return "Hacksaw Watermelon";
	}
	
	@Override
	public void load() {
		if(!mod_Hacksaw.initialized && !ModLoader.isModLoaded("mod_Hacksaw")){
			CoreConfiguration.init(null, "config/hacksaw/core.cfg" );
			Register.registerItemsAndBlocksAndRecipes();
			BlockReplacer.replaceVanillaBlocks();
			PluginLoader.checkPlugins();
			RecipeRemover.removeVanillaRecipes();
			mod_Hacksaw.initialized = true;
			ModLoader.getLogger().info("[Hacksaw] Hacksaw-Watermelon has successfully loaded");
		}else{
			ModLoader.getLogger().severe("[Hacksaw] Hacksaw-Watermelon is already loaded, check for a duplicate Hacksaw-Watermlon installed");
		}
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
