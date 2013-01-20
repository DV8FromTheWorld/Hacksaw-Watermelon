package hacksaw.core.util;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.util.HacksawLogger.LogLevel;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class CoreConfiguration extends Configuration {
	public static final String version = "v0.2";
	public static final String name = "Hacksaw-Watermelon";
	
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
				Property prop = get(Configuration.CATEGORY_GENERAL, USE_VANILLA_RECIPES, false);
				prop.comment = "Should we keep vanilla bread and meat recipes? (default: false)";
				
			//Gets the True/False for whether Debug Mode should be enabled	
				prop = get(Configuration.CATEGORY_GENERAL, ENABLE_DEBUG, false);
				prop.comment = "Enables Debug messages to track bugs (default: false)";
				
			//Gets the True/False for whether Debug Mode should be enabled	
				prop = get(Configuration.CATEGORY_GENERAL, AUTORESOLVE_CONFLICTS, true);
				prop.comment = "Attempt to automatically resolve item/block ID conflicts (default: false)";
				autoresolve = prop.getBoolean(false);
				
		//======================================== Machines ===========================================
		/*
		 * 		prop = get("grill", Configuration.CATEGORY_BLOCK, nextBlockId());
		 *		HacksawBlocks.grill.blockId = prop.getInt();
		 *		HacksawBlocks.grill.name = "Grill";
		 *
		 *		prop = get("grill.electric", Configuration.CATEGORY_BLOCK, nextBlockId());
		 *		HacksawBlocks.grillElectric.blockId = prop.getInt();
		 *		HacksawBlocks.grillElectric.name = "Electric Grill";
		 *
		 */
		//======================================== Vegetation =========================================
				prop = get(Configuration.CATEGORY_BLOCK, "supermelon", 103);	// intentionally clobbering vanilla melon
				HacksawBlocks.supermelon.blockId = prop.getInt();
				HacksawBlocks.supermelon.name = "Melon";
				
				prop = get(Configuration.CATEGORY_BLOCK, "carrot.crop", nextBlockId());
				HacksawBlocks.carrotCrop.blockId = prop.getInt();
				HacksawBlocks.carrotCrop.name = "Carrot Plant";
				
				prop = get(Configuration.CATEGORY_BLOCK, "lettuce.crop", nextBlockId());
				HacksawBlocks.lettuceCrop.blockId = prop.getInt();
				HacksawBlocks.lettuceCrop.name = "Lettuce Plant";
				
		//======================================== Food =========================================
			//Gets the ID and Name for the "Carrot"
				prop = get(Configuration.CATEGORY_ITEM, "food.carrot", nextItemId());
				HacksawItems.carrot.itemId = prop.getInt();
				HacksawItems.carrot.name = "Carrot";
		
			//Gets the ID for the "Sliced Carrot"
				prop = get(Configuration.CATEGORY_ITEM, "food.carrot.sliced", nextItemId());
				HacksawItems.carrotSliced.itemId = prop.getInt();
				HacksawItems.carrotSliced.name = "Sliced Carrots";
		
			//Gets the ID and Name for the "Lettuce"
				prop = get(Configuration.CATEGORY_ITEM, "food.lettuce", nextItemId());
				HacksawItems.lettuce.itemId = prop.getInt();
				HacksawItems.lettuce.name = "Lettuce";
		
			//Gets the ID for the "Sliced Lettuce"
				prop = get(Configuration.CATEGORY_ITEM, "food.lettuce.sliced", nextItemId());
				HacksawItems.lettuceSliced.itemId = prop.getInt();
				HacksawItems.lettuceSliced.name = "Sliced Lettuce";
				
			//Gets the ID for the "Raw Lamb Chop"
				prop = get(Configuration.CATEGORY_ITEM, "food.lamb.chop.raw", nextItemId());
				HacksawItems.lambChopRaw.itemId = prop.getInt();
				HacksawItems.lambChopRaw.name = "Raw Lamb Chop";
				
			//Gets the ID for the "Cooked Lamb Chop"
				prop = get(Configuration.CATEGORY_ITEM, "food.lamb.chop.cooked", nextItemId());
				HacksawItems.lambChopCooked.itemId = prop.getInt();
				HacksawItems.lambChopCooked.name = "Cooked Lamb Chop";
				
			//Gets the ID for the "Orange"
				prop = get(Configuration.CATEGORY_ITEM, "food.orange", nextItemId());
				HacksawItems.orange.itemId = prop.getInt();
				HacksawItems.orange.name = "Orange";
				
			//Gets the ID for the "Sliced Orange"
				prop = get(Configuration.CATEGORY_ITEM, "food.orange.sliced", nextItemId());
				HacksawItems.orangeSliced.itemId = prop.getInt();
				HacksawItems.orangeSliced.name = "Sliced Orange";
			
			//Gets the ID for the "Sliced Apple"
				prop = get(Configuration.CATEGORY_ITEM, "food.apple.red.sliced", nextItemId());
				HacksawItems.appleRedSliced.itemId = prop.getInt();
				HacksawItems.appleRedSliced.name = "Sliced Apple";
				
			//Gets the ID for the "Green Apple"
				prop = get(Configuration.CATEGORY_ITEM, "food.apple.green", nextItemId());
				HacksawItems.appleGreen.itemId = prop.getInt();
				HacksawItems.appleGreen.name = "Green Apple";
				
			//Gets the ID for the "Sliced Green Apple"
				prop = get(Configuration.CATEGORY_ITEM, "food.apple.green.sliced", nextItemId());
				HacksawItems.appleGreenSliced.itemId = prop.getInt();
				HacksawItems.appleGreenSliced.name = "Sliced Green Apple";
				
		//======================================== Seeds ========================================
			//Gets the ID for the "Carrot Seed"
				prop = get(Configuration.CATEGORY_ITEM, "food.carrot.seed", nextItemId());
				HacksawItems.carrotSeed.itemId = prop.getInt();
				HacksawItems.carrotSeed.name = "Carrot Seed";
				
				prop = get(Configuration.CATEGORY_ITEM, "food.lettuce.seed", nextItemId());
				HacksawItems.lettuceSeed.itemId = prop.getInt();
				HacksawItems.lettuceSeed.name = "Lettuce Seed";
				
		//======================================== Tools ========================================
			//Gets the ID for the "Sharp Chef Knife"
				prop = get(Configuration.CATEGORY_ITEM, "chef.knife.sharp", nextItemId());
				HacksawItems.chefKnifeSharp.itemId = prop.getInt();
				HacksawItems.chefKnifeSharp.name = "Sharp Chef's Knife";
				
			//Gets the ID for the "Dull Chef Knife"
				prop = get(Configuration.CATEGORY_ITEM, "chef.knife.dull", nextItemId());
				HacksawItems.chefKnifeDull.itemId = prop.getInt();
				HacksawItems.chefKnifeDull.name = "Dull Chef's Knife";
		
			//Gets the ID for the "Knife Sharpener"
				prop = get(Configuration.CATEGORY_ITEM, "chef.knife.sharpener", nextItemId());
				HacksawItems.knifeSharpener.itemId = prop.getInt();
				HacksawItems.knifeSharpener.name = "Knife Sharpener";
	}	
	public static boolean getPreference( String propName ) {
		Property prop = INSTANCE.get(CATEGORY_GENERAL, propName, false);
		if( prop != null && prop.isBooleanValue() ) {
			return prop.getBoolean(false);
		}
		return false;
	}
	
	@Override
	public void save() {
		Property versionProp = get(Configuration.CATEGORY_GENERAL, "version", "0.0");
		versionProp.value = version;
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
		// TODO :: Resolved Null pointer on Add.
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
		// TODO :: Resolved Null pointer on Add.
		claimed_items.add(Integer.valueOf(id));
		return id;
	}
	private int nextItemId() {
		int id = nextItemId(next_item_id);
		next_item_id = id+1;
		return id;
	}
}
