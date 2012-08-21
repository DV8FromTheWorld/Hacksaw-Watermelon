package hacksaw.core.util;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.util.HacksawLogger.LogLevel;

import java.io.File;

import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.Property;

public class CoreConfiguration extends Configuration {
	private static final String version = "v0.1";
	private static final String name = "Hacksaw-Watermelon";
	public static final String USE_VANILLA_RECIPES = "useVanillaRecipes";
	public static final String ENABLE_DEBUG = "Debug Mode";
	
	private static CoreConfiguration INSTANCE = null;
	public static CoreConfiguration getInstance() {
		return INSTANCE;
	}

	private CoreConfiguration(File file) {
		super(file);
	}
	
	public static void init( File minecraftDir, String path ) {
		if( INSTANCE != null ) {
			HacksawLogger.log(LogLevel.WARNING, "Blocked attempt to Re-Init configuration");
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
				
			//Gets the True/False for whether Debug Mode should be enabled	
				prop = getOrCreateBooleanProperty(ENABLE_DEBUG, Configuration.CATEGORY_GENERAL, false);
				prop.comment = "Enables Debug messages to track bugs (default: false)";				
				
		//======================================== Vegetation =========================================
				prop = getOrCreateIntProperty("supermelon", Configuration.CATEGORY_BLOCK, 103);
				HacksawBlocks.supermelon.blockId = prop.getInt();
				HacksawBlocks.supermelon.name = "Melon";
				
				prop = getOrCreateIntProperty("carrot", Configuration.CATEGORY_BLOCK, 104);
				HacksawBlocks.carrot.blockId = prop.getInt();
				HacksawBlocks.carrot.name = "Carrot Plant";
				
		//======================================== Food =========================================
			//Gets the ID and Name for the "Carrot"
				prop = getOrCreateIntProperty("carrot", Configuration.CATEGORY_ITEM, 1004);
				HacksawItems.carrot.itemId = prop.getInt();
				HacksawItems.carrot.name = "Carrot";
		
			//Gets the ID for the "Sliced Carrot"
				prop = getOrCreateIntProperty("carrot.sliced", Configuration.CATEGORY_ITEM, 1005);
				HacksawItems.carrotSliced.itemId = prop.getInt();
				HacksawItems.carrotSliced.name = "Sliced Carrots";
				
			//Gets the ID for the "Raw Lamb Chop"
				prop = getOrCreateIntProperty("lamb.chop.raw", Configuration.CATEGORY_ITEM, 1006);
				HacksawItems.lambChopRaw.itemId = prop.getInt();
				HacksawItems.lambChopRaw.name = "Raw Lamb Chop";
				
			//Gets the ID for the "Cooked Lamb Chop"
				prop = getOrCreateIntProperty("lamb.chop.cooked", Configuration.CATEGORY_ITEM, 1007);
				HacksawItems.lambChopCooked.itemId = prop.getInt();
				HacksawItems.lambChopCooked.name = "Cooked Lamb Chop";
				
			//Gets the ID for the "Orange"
				prop = getOrCreateIntProperty("orange", Configuration.CATEGORY_ITEM, 1008);
				HacksawItems.orange.itemId = prop.getInt();
				HacksawItems.orange.name = "Orange";
				
			//Gets the ID for the "Sliced Orange"
				prop = getOrCreateIntProperty("orange.sliced", Configuration.CATEGORY_ITEM, 1009);
				HacksawItems.orangeSliced.itemId = prop.getInt();
				HacksawItems.orangeSliced.name = "Sliced Orange";
			
			//Gets the ID for the "Sliced Apple"
				prop = getOrCreateIntProperty("apple.sliced", Configuration.CATEGORY_ITEM, 1010);
				HacksawItems.appleSliced.itemId = prop.getInt();
				HacksawItems.appleSliced.name = "Sliced Apple";
				
		//======================================== Tools ========================================
			//Gets the ID for the "Carrot Seed"
				prop = getOrCreateIntProperty("carrot.seed", Configuration.CATEGORY_ITEM, 1011);
				HacksawItems.carrotSeed.itemId = prop.getInt();
				HacksawItems.carrotSeed.name = "Carrot Seed";
				
		//======================================== Tools ========================================
			//Gets the ID for the "Sharp Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.sharp", Configuration.CATEGORY_ITEM, 1000);
				HacksawItems.chefKnifeSharp.itemId = prop.getInt();
				HacksawItems.chefKnifeSharp.name = "Sharp Chef Knife";
				
			//Gets the ID for the "Dull Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.dull", Configuration.CATEGORY_ITEM, 1001);
				HacksawItems.chefKnifeDull.itemId = prop.getInt();
				HacksawItems.chefKnifeDull.name = "Dull Chef Knife";
		
			//Gets the ID for the "Knife Sharpener"
				prop = getOrCreateIntProperty("knife.sharpener", Configuration.CATEGORY_ITEM, 1002);
				HacksawItems.knifeSharpener.itemId = prop.getInt();
				HacksawItems.knifeSharpener.name = "Knife Sharpener";
	}	
	public static boolean getPreference( String propName ) {
		Property prop = INSTANCE.generalProperties.get(propName);
		if( prop != null && prop.isBooleanValue() ) {
			return prop.getBoolean(false);
		}
		return false;
	}

	public static String getVersion() {
		return version;
	}

	public static String getName() {
		return name;
	}
	
	@Override
	public void save() {
		Property versionProp = getOrCreateProperty("version", Configuration.CATEGORY_GENERAL, "0.0");
		versionProp.value = getVersion();
		super.save();
	}
}
