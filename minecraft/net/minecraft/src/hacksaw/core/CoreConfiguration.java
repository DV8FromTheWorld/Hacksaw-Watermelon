package net.minecraft.src.hacksaw.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;

public class CoreConfiguration extends Configuration{

	public CoreConfiguration(File file) {
		super(file);
	}

	static Configuration configuration = new Configuration(new File(Minecraft.getMinecraftDir(), "config/hacksaw/HacksawCore.cfg"));
	static int flatBreadItemID = configurationProperties();
	static int multigrainBreadItemID;
	public static boolean useVanillaRecipes;
	
	public static int configurationProperties() {
		configuration.load();
		flatBreadItemID = Integer.parseInt(configuration.getOrCreateIntProperty("Flat Bread", Configuration.CATEGORY_ITEM, 385).value);	//EXAMPLE, only make a config entry
		multigrainBreadItemID = Integer.parseInt(configuration.getOrCreateIntProperty("Multigrain Bread", Configuration.CATEGORY_ITEM, 384).value);   //EXAMPLE, only make a config entry
		useVanillaRecipes = Boolean.parseBoolean(configuration.getOrCreateBooleanProperty("Use Vanilla Recipes" , Configuration.CATEGORY_GENERAL, false).value);
		configuration.save();
		return flatBreadItemID;
	}
	
}
