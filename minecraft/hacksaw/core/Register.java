package hacksaw.core;

import hacksaw.core.items.ItemChefKnifeDull;
import hacksaw.core.items.ItemChefKnifeSharp;
import hacksaw.core.items.ItemKnifeSharpener;
import hacksaw.core.util.CoreConfiguration;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Register {
	
	public static void registerItemsAndBlocksAndRecipes(){
		//------------------- Registers blocks ----------------------
			//TODO for when we add blocks
		
		
		//---------------------- Registers the Items ------------------------
			HacksawItems.chefKnifeSharp.item = new ItemChefKnifeSharp(HacksawItems.chefKnifeSharp.itemId);
			HacksawItems.chefKnifeDull.item = new ItemChefKnifeDull(HacksawItems.chefKnifeDull.itemId);
			HacksawItems.knifeSharpener.item = new ItemKnifeSharpener(HacksawItems.knifeSharpener.itemId);
		
		
		//-------------------- Registers the names for the blocks ----------------------
			//TODO for when we add blocks
		
		
		
		//--------------------- Registers the names for the items -----------------------
			ModLoader.addName(HacksawItems.chefKnifeSharp.item, "Chef Knife");
			ModLoader.addName(HacksawItems.chefKnifeDull.item, "Dull Chef Knife");
			ModLoader.addName(HacksawItems.knifeSharpener.item, "Knife Sharpener");
		
		//-------------------- Registers the shaped-recipes --------------------
			//recipe for creating the Chef knife.  Contains full durability, so it is the "Sharp Chef Knife"
			ModLoader.addRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item, 1), new Object[]{
				"  Y", " XY", "XY ", Character.valueOf('X'), Item.stick, Character.valueOf('Y'), Item.ingotIron
			});
			
			//recipe for creating a Knife Sharpener
			ModLoader.addRecipe(new ItemStack(HacksawItems.knifeSharpener.item, 1), new Object[]{
				"X X", "YXY", "ZZZ", Character.valueOf('X'), Item.flint, Character.valueOf('Y'), Block.cobblestone, Character.valueOf('Z'), Block.planks
			});
		
		
		//------------------- Registers the shapeless-recipes ------------------	
			//recipe for using the Chef knife to cut melon blocks to get melon slices
			ModLoader.addShapelessRecipe(new ItemStack(Item.melon, 5), new Object[]{
				Block.melon, new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1)//Note: a new itemstack is made here because you want to be able to use the item no matter what the damage value
			});
			
			//recipe for "sharpening" the Dull Chef knife
			ModLoader.addShapelessRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item), new Object[]{
				 HacksawItems.chefKnifeDull.item, new ItemStack(HacksawItems.knifeSharpener.item, 1, -1)
			});
						
	}	
	
}
