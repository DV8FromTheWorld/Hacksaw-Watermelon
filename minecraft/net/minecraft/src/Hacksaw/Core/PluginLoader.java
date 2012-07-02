package net.minecraft.src.Hacksaw.Core;

import net.minecraft.src.ModLoader;

public class PluginLoader {
	public static boolean IC2exists;
	public static boolean EE2exists;
	public static boolean ThaumcraftExists;
	
	
	public static void loadPlugins(){
		loadIc2Integration();
		loadEquivalentExchangeIntegration();
		loadThaumcraftIntegration();
	}
	
	public static void loadIc2Integration(){
		try{
			ModLoader.getLogger().info("Trying to load Industrialcraft 2 integration.");
			Class<?> IC2 = Class.forName("mod_IC2");
			IC2exists = true;//not really needed, but here if needed in future.
			//insert code to load IC2 integration here
			
			ModLoader.getLogger().info("IC2 integration was successfully loaded.");
			
			}catch(ClassNotFoundException e){
				ModLoader.getLogger().info("IC2 was not found.");
				IC2exists = false;//not really needed, but here if needed in future.
			}
		
	}
	
	public static void loadEquivalentExchangeIntegration(){
		try{
			ModLoader.getLogger().info("Trying to load Equivalent Exchange Integration.");
			Class <?> EE2 = Class.forName("mod_EE");
			EE2exists = true;//not really needed, but here if needed in future.
			//insert code to load EE2 integration here
			
			ModLoader.getLogger().info("Equivalent Exchange Integration was successfully loaded.");
			
			}catch(ClassNotFoundException e){
				ModLoader.getLogger().info("Equivalent Exchange was not found.");
				EE2exists = false;//not really needed, but here if needed in future.
			}
			
	}
	
	public static void loadThaumcraftIntegration(){
		try{
			ModLoader.getLogger().info("Trying to load Thaumcaft Integration.");
			Class <?> Thaumcraft = Class.forName("mod_ThaumCraft");
			ThaumcraftExists = true;//not really needed, but here if needed in future.
			//insert code to load Thaumcraft integration here
			
			ModLoader.getLogger().info("Thaumcraft Integration was successfully loaded.");
			
			}catch(ClassNotFoundException e){
				ModLoader.getLogger().info("Thaumcraft was not found.");
				ThaumcraftExists = false;//not really needed, but here if needed in future.
			}
	}
}
