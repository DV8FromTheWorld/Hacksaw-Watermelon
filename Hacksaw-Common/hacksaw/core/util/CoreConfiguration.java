package hacksaw.core.util;

import hacksaw.core.HacksawItems;

import java.io.File;

import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_Hacksaw;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.Property;

public class CoreConfiguration extends Configuration {
	public static final String USE_VANILLA_RECIPES = "useVanillaRecipes";
	
	private static CoreConfiguration INSTANCE = null;
	public static CoreConfiguration getInstance() {
		return INSTANCE;
	}

	private CoreConfiguration(File file) {
		super(file);
	}
	
	public static void init( File minecraftDir, String path ) {
		if( INSTANCE != null ) {
			ModLoader.getLogger().warning("[Hacksaw] blocked attempt to reinit config");
			return;
		}
		final File file;
		if (minecraftDir != null) {
			file = new File(minecraftDir, path);
		} else {
			file = new File(path);
		}
		INSTANCE = new CoreConfiguration(file);
		
		INSTANCE.load();
		INSTANCE.populateDefaults();
		INSTANCE.save();
	}
	
	private void populateDefaults() {
		
		//====================================== Options ==========================================
			//Gets the True/False for whether Vanilla recipes should or shouldn't be used for cooking
				Property prop = getOrCreateBooleanProperty(USE_VANILLA_RECIPES, Configuration.CATEGORY_GENERAL, false);
				prop.comment = "Should we keep vanilla bread and meat recipes? (default: false)";
		
		//======================================== Food =========================================
			//Gets the ID for the "Carrot"
				prop = getOrCreateIntProperty("carrot", Configuration.CATEGORY_ITEM, 1004);
				HacksawItems.carrot.itemId = prop.getInt();
		
			//Gets the ID for the "Sliced Carrot"
				prop = getOrCreateIntProperty("carrot.sliced", Configuration.CATEGORY_ITEM, 1005);
				HacksawItems.carrotSliced.itemId = prop.getInt();
				
			//Gets the ID for the "Raw Lamb Chop"
				prop = getOrCreateIntProperty("lamb.chop.raw", Configuration.CATEGORY_ITEM, 1006);
				HacksawItems.lambChopRaw.itemId = prop.getInt();
				
			//Gets the ID for the "Cooked Lamb Chop"
				prop = getOrCreateIntProperty("lamb.chop.cooked", Configuration.CATEGORY_ITEM, 1007);
				HacksawItems.lambChopCooked.itemId = prop.getInt();
			
		//======================================== Tools ========================================
			//Gets the ID for the "Sharp Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.sharp", Configuration.CATEGORY_ITEM, 1000);
				HacksawItems.chefKnifeSharp.itemId = prop.getInt();
			
			//Gets the ID for the "Dull Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.dull", Configuration.CATEGORY_ITEM, 1001);
				HacksawItems.chefKnifeDull.itemId = prop.getInt();
		
			//Gets the ID for the "Knife Sharpener"
				prop = getOrCreateIntProperty("knife.sharpener", Configuration.CATEGORY_ITEM, 1002);
				HacksawItems.knifeSharpener.itemId = prop.getInt();
	}
	
	public static boolean getPreference( String propName ) {
		Property prop = INSTANCE.generalProperties.get(propName);
		if( prop != null && prop.isBooleanValue() ) {
			return prop.getBoolean(false);
		}
		return false;
	}
	
	@Override
	public void save() {
		Property version = getOrCreateProperty("version", Configuration.CATEGORY_GENERAL, mod_Hacksaw.version());
		super.save();
	}
}
