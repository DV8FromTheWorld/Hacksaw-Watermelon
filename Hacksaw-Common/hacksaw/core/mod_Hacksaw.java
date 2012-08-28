package hacksaw.core;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import hacksaw.core.CommonProxy;
import hacksaw.core.PluginLoader;
import hacksaw.core.RecipeRemover;
import hacksaw.core.mod_Hacksaw;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.Register;
import hacksaw.core.util.HacksawLogger.LogLevel;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;

@Mod(modid = "HSWM", name= CoreConfiguration.name, version= CoreConfiguration.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class mod_Hacksaw{
	
	@SidedProxy(clientSide = "hacksaw.core.ClientProxy", serverSide = "hacksaw.core.CommonProxy")
	public static CommonProxy proxy;
	
	public static boolean initialized = false;
	
	@PreInit
	public void preInitialization(FMLPreInitializationEvent event){
		
	}

	@Init
	public void Initialize(FMLInitializationEvent event){
		if(!mod_Hacksaw.initialized /*&& !ModLoader.isModLoaded("mod_Hacksaw")*/){
			HacksawLogger.log("Loading " + CoreConfiguration.name + "...");
			proxy.preloadTextures();
			CoreConfiguration.init(proxy.path, "config/hacksaw/core.cfg");
			//HacksawLogger.checkDebugSetting();  <-- commented until we can get it to work correctly :3
			Register.registerItemsAndBlocksAndRecipes();
			PluginLoader.checkPlugins();
			RecipeRemover.removeVanillaRecipes();
			mod_Hacksaw.initialized = true;
			HacksawLogger.log(CoreConfiguration.name + " " +CoreConfiguration.version+ " has successfully loaded");
		}else{
			HacksawLogger.log( LogLevel.SEVERE, "Hacksaw-Watermelon is already loaded, check for a duplicate Hacksaw-Watermlon installed");
		}
	}
	
	@PostInit
	public void postInitialization(FMLPostInitializationEvent event){
		CraftingStuff.init();
	}
	
}
