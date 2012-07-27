package net.minecraft.src;

import hacksaw.core.HacksawItems;
import hacksaw.core.PluginLoader;
import hacksaw.core.RecipeRemover;
import hacksaw.core.Register;
import hacksaw.core.items.ItemSharpChefKnife;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;

import java.io.File;

import cpw.mods.fml.common.modloader.BaseMod;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;

public class mod_Hacksaw extends NetworkMod {

	//public static final Item knife = new ItemChefKnife(HacksawItems.chefKnife.itemId).setItemName("Knife");
	
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
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/items.png");
		CoreConfiguration.init( "config/hacksaw/core.cfg" );
		Register.registerItemsAndBlocksAndRecipes();
		PluginLoader.checkPlugins();
		RecipeRemover.removeVanillaRecipes();
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
