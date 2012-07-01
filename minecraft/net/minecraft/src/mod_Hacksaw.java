package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.Hacksaw.Core.CoreConfiguration;
import net.minecraft.src.Hacksaw.Core.PluginLoader;
import net.minecraft.src.Hacksaw.Core.RecipeRemover;

public class mod_Hacksaw extends NetworkMod{

	//config moved to "CoreConfiguration" 
	
	@Override
	public String getVersion() {
		return version();
	}
	
	public static String version(){
		return "0.0";
	}

	@Override
	public void load() {
		System.out.println("Hey, i got loaded right yo!"); //for testing purposes only
		CoreConfiguration.configurationProperties();
		PluginLoader.loadPlugins();  //doesn't work yet, still working on it.
		RecipeRemover.removeVanillaRecipes();
	}

	public boolean clientSideRequired()
    {
        return true;
    }

	
	public boolean serverSideRequired()
    {
        return false;
    }
	
}
