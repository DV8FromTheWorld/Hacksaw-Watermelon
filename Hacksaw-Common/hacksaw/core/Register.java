package hacksaw.core;

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
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Register {
	
	
	public static void registerItemsAndBlocksAndRecipes(){
		//====================== Registers blocks ======================== 
			//TODO for when we add blocks
			//---------Vegetation----------
				HacksawBlocks.supermelon.block = new BlockSuperMelon(HacksawBlocks.supermelon.blockId);
		
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
				
				
		//==================== Registers the names for the blocks ======================
			//TODO for when we add blocks
			//---------Vegetation----------
				ModLoader.addName(HacksawBlocks.supermelon.block, "Melon");
		
		
		//======================= Registers the names for the items =======================
			
			//---------Tools----------
				ModLoader.addName(HacksawItems.chefKnifeSharp.item, "Chef Knife");
				ModLoader.addName(HacksawItems.chefKnifeDull.item, "Dull Chef Knife");
				ModLoader.addName(HacksawItems.knifeSharpener.item, "Knife Sharpener");
			
			//---------Food-----------
				ModLoader.addName(HacksawItems.carrot.item, "Carrot");
				ModLoader.addName(HacksawItems.carrotSliced.item, "Sliced Carrots");
				ModLoader.addName(HacksawItems.lambChopRaw.item, "Raw Lamb Chop");
				ModLoader.addName(HacksawItems.lambChopCooked.item, "Cooked Lamb Chop");
		
		//==================== Registers the shaped-recipes ====================
			//recipe for creating the Chef knife.  Contains full durability, so it is the "Sharp Chef Knife"
				ModLoader.addRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item, 1), new Object[]{
					"  Y", " XY", "XY ", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron
				});
			
			//recipe for creating a Knife Sharpener
				ModLoader.addRecipe(new ItemStack(HacksawItems.knifeSharpener.item, 1), new Object[]{
					"X X", "YXY", "ZZZ", Character.valueOf('X'), Item.flint, Character.valueOf('Y'), Block.cobblestone, Character.valueOf('Z'), Block.planks
				});	
		
		//=================== Registers the shapeless-recipes ====================	
			//recipe for using the Chef knife to cut melon blocks to get melon slices
				ModLoader.addShapelessRecipe(new ItemStack(Item.melon, 4), new Object[]{
					Block.melon, new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1)//Note: a new itemstack is made here because you want to be able to use the item no matter what the damage value
				});
			
			//recipe for "sharpening" the Dull Chef knife
				ModLoader.addShapelessRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item), new Object[]{
					 HacksawItems.chefKnifeDull.item, new ItemStack(HacksawItems.knifeSharpener.item, 1, -1)
				});
				
		//================== Registers the cooking recipes for the Grill ===================				
			//
				GrillCook.getInstance().addToGrillToCook(HacksawItems.lambChopRaw.item.shiftedIndex, new ItemStack(HacksawItems.lambChopCooked.item), 25);
	}	
				
}
