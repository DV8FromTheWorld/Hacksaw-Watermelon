package hacksaw.core.util;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.util.HacksawLogger.LogLevel;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.Property;

public class CoreConfiguration extends Configuration {
	private static final String version = "v0.1";
	private static final String name = "Hacksaw-Watermelon";
	
	private static final int START_BLOCK_ID = 1200;
	private static final int START_ITEM_ID = 1000;
	
	public static final String USE_VANILLA_RECIPES = "useVanillaRecipes";
	public static final String ENABLE_DEBUG = "debugMode";
	public static final String AUTORESOLVE_CONFLICTS = "autoresolveConflicts";
	
	private boolean autoresolve = false;
	
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
				
			//Gets the True/False for whether Debug Mode should be enabled	
				prop = getOrCreateBooleanProperty(AUTORESOLVE_CONFLICTS, Configuration.CATEGORY_GENERAL, true);
				prop.comment = "Attempt to automatically resolve item/block ID conflicts (default: false)";
				autoresolve = prop.getBoolean(false);
				
		//======================================== Vegetation =========================================
				prop = getOrCreateIntProperty("supermelon", Configuration.CATEGORY_BLOCK, 103);	// intentionally clobbering vanilla melon
				HacksawBlocks.supermelon.blockId = prop.getInt();
				HacksawBlocks.supermelon.name = "Melon";
				
				prop = getOrCreateIntProperty("carrot.crop", Configuration.CATEGORY_BLOCK, nextBlockId());
				HacksawBlocks.carrotCrop.blockId = prop.getInt();
				HacksawBlocks.carrotCrop.name = "Carrot Plant";
				
		//======================================== Food =========================================
			//Gets the ID and Name for the "Carrot"
				prop = getOrCreateIntProperty("food.carrot", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.carrot.itemId = prop.getInt();
				HacksawItems.carrot.name = "Carrot";
		
			//Gets the ID for the "Sliced Carrot"
				prop = getOrCreateIntProperty("food.carrot.sliced", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.carrotSliced.itemId = prop.getInt();
				HacksawItems.carrotSliced.name = "Sliced Carrots";
				
			//Gets the ID for the "Raw Lamb Chop"
				prop = getOrCreateIntProperty("food.lamb.chop.raw", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.lambChopRaw.itemId = prop.getInt();
				HacksawItems.lambChopRaw.name = "Raw Lamb Chop";
				
			//Gets the ID for the "Cooked Lamb Chop"
				prop = getOrCreateIntProperty("food.lamb.chop.cooked", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.lambChopCooked.itemId = prop.getInt();
				HacksawItems.lambChopCooked.name = "Cooked Lamb Chop";
				
			//Gets the ID for the "Orange"
				prop = getOrCreateIntProperty("food.orange", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.orange.itemId = prop.getInt();
				HacksawItems.orange.name = "Orange";
				
			//Gets the ID for the "Sliced Orange"
				prop = getOrCreateIntProperty("food.orange.sliced", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.orangeSliced.itemId = prop.getInt();
				HacksawItems.orangeSliced.name = "Sliced Orange";
			
			//Gets the ID for the "Sliced Apple"
				prop = getOrCreateIntProperty("food.apple.red.sliced", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.appleRedSliced.itemId = prop.getInt();
				HacksawItems.appleRedSliced.name = "Sliced Apple";
				
			//Gets the ID for the "Green Apple"
				prop = getOrCreateIntProperty("food.apple.green", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.appleGreen.itemId = prop.getInt();
				HacksawItems.appleGreen.name = "Green Apple";
				
			//Gets the ID for the "Sliced Green Apple"
				prop = getOrCreateIntProperty("food.apple.green.sliced", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.appleGreenSliced.itemId = prop.getInt();
				HacksawItems.appleGreenSliced.name = "Sliced Green Apple";
				
		//======================================== Seeds ========================================
			//Gets the ID for the "Carrot Seed"
				prop = getOrCreateIntProperty("food.carrot.seed", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.carrotSeed.itemId = prop.getInt();
				HacksawItems.carrotSeed.name = "Carrot Seed";
				
		//======================================== Tools ========================================
			//Gets the ID for the "Sharp Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.sharp", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.chefKnifeSharp.itemId = prop.getInt();
				HacksawItems.chefKnifeSharp.name = "Sharp Chef's Knife";
				
			//Gets the ID for the "Dull Chef Knife"
				prop = getOrCreateIntProperty("chef.knife.dull", Configuration.CATEGORY_ITEM, nextItemId());
				HacksawItems.chefKnifeDull.itemId = prop.getInt();
				HacksawItems.chefKnifeDull.name = "Dull Chef's Knife";
		
			//Gets the ID for the "Knife Sharpener"
				prop = getOrCreateIntProperty("chef.knife.sharpener", Configuration.CATEGORY_ITEM, nextItemId());
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
	
	//======================================== Automatic ID conflict resolution ===================
	private Set<Integer> claimed_blocks = new HashSet<Integer>();
	private Set<Integer> claimed_items = new HashSet<Integer>();
	private int next_block_id = START_BLOCK_ID;
	private int next_item_id = START_ITEM_ID;
	
	private int nextBlockId( int id ) {
		if( !autoresolve )
			return id;
		final int oid = id;
		while( Block.blocksList[id] != null || claimed_blocks.contains(Integer.valueOf(id))) {
			++id;
		}
		if( oid != id ) {
			HacksawLogger.log("Block ID conflict @ "+oid+", taken by "+Block.blocksList[oid]+", assigning "+id);
		}
		// TODO : Resolved Null pointer on Add.
		claimed_blocks.add(Integer.valueOf(id));
		return id;
	}
	private int nextBlockId() {
		int id = nextBlockId(next_block_id);
		next_block_id = id+1;
		return id;
	}
	
	private int nextItemId( int id ) {
		if( !autoresolve )
			return id;
		final int oid = id;
		while( Item.itemsList[id+256] != null || claimed_items.contains(Integer.valueOf(id))) {
			++id;
		}
		if( oid != id ) {
			HacksawLogger.log("Item ID conflict @ "+oid+", taken by "+Item.itemsList[oid+256]+", assigning "+id);
		}
		// TODO : Resolved Null pointer on Add.
		claimed_items.add(Integer.valueOf(id));
		return id;
	}
	private int nextItemId() {
		int id = nextItemId(next_item_id);
		next_item_id = id+1;
		return id;
	}
}
