package hacksaw.core;

import java.lang.reflect.Field;

import cpw.mods.fml.common.ReflectionHelper;
import hacksaw.api.GrillCook;
import hacksaw.core.blocks.BlockSuperMelon;
import hacksaw.core.items.ItemCarrot;
import hacksaw.core.items.ItemCarrotSliced;
import hacksaw.core.items.ItemChefKnifeDull;
import hacksaw.core.items.ItemChefKnifeSharp;
import hacksaw.core.items.ItemKnifeSharpener;
import hacksaw.core.items.ItemLambChopCooked;
import hacksaw.core.items.ItemLambChopRaw;
import hacksaw.core.machines.GrillRecipes;
import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.HacksawDebugLoggerLevel;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Register {
	
	
	public static void registerItemsAndBlocksAndRecipes(){
		registerBlocks();
		registerBlockNames();
		registerItems();
		registerItemNames();
		addShapedRecipes();
		addShapelessRecipes();
		addGrillRecipes();
	}

	private static void addGrillRecipes() {
		//================== Registers the cooking recipes for the Grill ===================
		
		GrillCook.getInstance().addToGrillToCook(HacksawItems.lambChopRaw.item.shiftedIndex, new ItemStack(HacksawItems.lambChopCooked.item), 25);
	}
	
	private static void registerBlocks() {
		//====================== Registers blocks ========================
		
		//---------Vegetation----------
			// if the block was removed
			if (BlockRemover.removeVanillaBlock(Block.melon)) {
				// initialize the block
				HacksawBlocks.supermelon.block = new BlockSuperMelon(HacksawBlocks.supermelon.blockId).setBlockName("melon");
				// log some success message
				ModLoader.getLogger().log(HacksawDebugLoggerLevel.HS_DEBUG, "BlockSuperMelon loaded successfully.");
			}
			
		//========= Register Each Block ==============
			
			// for each Block within the enum (HacksawBlocks)
			for (HacksawBlocks blocks : HacksawBlocks.values()) {
				// Check the block is initialized
				if (blocks.block != null) {
					// Register the block with ModLoader
					ModLoader.registerBlock(blocks.block);
				}
			}
	}

	private static void registerBlockNames() {
		//==================== Registers the names for the blocks ======================
		
			// for each Block within the enum (HacksawBlocks)
			for (HacksawBlocks blocks : HacksawBlocks.values()) {
				// Check that the block is initialized and the block name is set
				if (blocks.block != null && blocks.name != null) {
					// Register the name of the block with ModLoader
					ModLoader.addName(blocks.block, blocks.name);
				}
			}
	}

	private static void registerItems() {
		//====================== Registers the Items ========================
		
		//---------Tools----------
			HacksawItems.chefKnifeSharp.item = new ItemChefKnifeSharp(HacksawItems.chefKnifeSharp.itemId);
			HacksawItems.chefKnifeDull.item = new ItemChefKnifeDull(HacksawItems.chefKnifeDull.itemId);
			HacksawItems.knifeSharpener.item = new ItemKnifeSharpener(HacksawItems.knifeSharpener.itemId);
		
		//---------Food-----------		
			HacksawItems.carrot.item = new ItemCarrot(HacksawItems.carrot.itemId, 2, 2, false);
			HacksawItems.carrotSliced.item = new ItemCarrotSliced(HacksawItems.carrotSliced.itemId, 1, 1, false);
			HacksawItems.lambChopRaw.item = new ItemLambChopRaw(HacksawItems.lambChopRaw.itemId, 3, 0.3F, false);
			HacksawItems.lambChopCooked.item = new ItemLambChopCooked(HacksawItems.lambChopCooked.itemId, 7, 0.7F, false);
	}

	private static void registerItemNames() {
		//======================= Registers the names for the items =======================
		
			// for each Item within the enum (HacksawItems)
			for (HacksawItems items : HacksawItems.values()) {
				// Check that the item is initialized and the item name is set
				if (items.item != null & items.name != null) {
					// Register the name of the item with ModLoader
					ModLoader.addName(items.item, items.name);
				}
			}
	}
	
	private static void addShapedRecipes() {
		//==================== Registers the shaped-recipes ====================
		
		//recipe for creating the Chef knife.  Contains full durability, so it is the "Sharp Chef Knife"
			ModLoader.addRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item, 1), new Object[]{
				"  Y", " XY", "XY ", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron
			});
		
		//recipe for creating a Knife Sharpener
			ModLoader.addRecipe(new ItemStack(HacksawItems.knifeSharpener.item, 1), new Object[]{
				"X X", "YXY", "ZZZ", Character.valueOf('X'), Item.flint, Character.valueOf('Y'), Block.cobblestone, Character.valueOf('Z'), Block.planks
			});	
	}
	
	private static void addShapelessRecipes() {
		//=================== Registers the shapeless-recipes ====================
			
		//recipe for using the Chef knife to cut melon blocks to get melon slices
			ModLoader.addShapelessRecipe(new ItemStack(Item.melon, 4), new Object[]{
				Block.melon, new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1)//Note: a new itemstack is made here because you want to be able to use the item no matter what the damage value
			});
		
		//recipe for "sharpening" the Dull Chef knife
			ModLoader.addShapelessRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item), new Object[]{
				 HacksawItems.chefKnifeDull.item, new ItemStack(HacksawItems.knifeSharpener.item, 1, -1)
			});
	}
}
