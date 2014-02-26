package hacksaw.core;

import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.CraftingStuff;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.HacksawLogger.LogLevel;
import hacksaw.core.util.Register;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = CoreConfiguration.MOD_ID, name = CoreConfiguration.MOD_NAME, version = CoreConfiguration.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_Hacksaw
{

    @Instance(CoreConfiguration.MOD_ID)
    public static mod_Hacksaw INSTANCE;

    @SidedProxy(clientSide = CoreConfiguration.CLIENT_PROXY, serverSide = CoreConfiguration.COMMON_PROXY)
    public static CommonProxy proxy;

    public static boolean initialized = false;

    @EventHandler
    public void preInitialization(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void Initialize(FMLInitializationEvent event)
    {
        if (!mod_Hacksaw.initialized)
        {
            HacksawLogger.log("Loading " + CoreConfiguration.MOD_NAME + "...");
            proxy.preloadTextures();
            CoreConfiguration.init(CommonProxy.path, "config/hacksaw/core.cfg");
            RecipeRemover.removeVanillaRecipes();
            //HacksawLogger.checkDebugSetting();  <-- commented until we can get it to work correctly
            Register.registerItemsAndBlocksAndRecipes();
            PluginLoader.checkPlugins();
            mod_Hacksaw.initialized = true;
            HacksawLogger.log(CoreConfiguration.MOD_NAME + " " + CoreConfiguration.MOD_VERSION + " has successfully loaded");
        }
        else
        {
            HacksawLogger.log(LogLevel.SEVERE, "Hacksaw-Watermelon is already loaded, check for a duplicate Hacksaw-Watermlon installed");
        }
    }

    @EventHandler
    public void postInitialization(FMLPostInitializationEvent event)
    {
        CraftingStuff.init();
    }
}
