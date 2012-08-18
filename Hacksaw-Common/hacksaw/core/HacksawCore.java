package hacksaw.core;

import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.Register;
import net.minecraft.src.mod_Hacksaw;

public class HacksawCore {
	
	public static void init(){
		CoreConfiguration.init(mod_Hacksaw.path, "config/hacksaw/core.cfg");
		//HacksawLogger.checkDebugSetting();  <-- commented until we can get it to work correctly :3
		Register.registerItemsAndBlocksAndRecipes();
		PluginLoader.checkPlugins();
		RecipeRemover.removeVanillaRecipes();
		mod_Hacksaw.initialized = true;
	}

}
