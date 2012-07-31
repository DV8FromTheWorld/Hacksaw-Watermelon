package hacksaw.core;

import hacksaw.core.items.ItemDullChefKnife;
import hacksaw.core.items.ItemKnifeSharpener;
import hacksaw.core.items.ItemSharpChefKnife;
import hacksaw.core.util.CoreConfiguration;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Register {
	
	public static void registerItemsAndBlocksAndRecipes(){
		//Registers blocks and there specifics (blockID, harvest level, etc)
			//TODO for when we add blocks
		
		
		//Registers the Items (all specifics like "texture file, harvest level, max item stack" are defined in the item class already)
		HacksawItems.sharpChefKnife.item = new ItemSharpChefKnife(HacksawItems.sharpChefKnife.itemId);
		HacksawItems.dullChefKnife.item = new ItemDullChefKnife(HacksawItems.dullChefKnife.itemId);
		HacksawItems.knifeSharpener.item = new ItemKnifeSharpener(HacksawItems.knifeSharpener.itemId);
		
		
		//Registers the names for the blocks
			//TODO for when we add blocks
		
		
		
		//Registers the names for the items
		ModLoader.addName(HacksawItems.sharpChefKnife.item, "Chef Knife");
		ModLoader.addName(HacksawItems.dullChefKnife.item, "Dull Chef Knife");
		ModLoader.addName(HacksawItems.knifeSharpener.item, "Knife Sharpener");
		
		//Registers the shaped-recipes for items
			//TODO for items
		
		
		
		//Registers the shapeless-recipes for items
		
			//recipe for using the Chef knife to cut melon blocks to get melon slices
			ModLoader.addShapelessRecipe(new ItemStack(Item.melon, 5), new Object[]{
				Block.melon, new ItemStack(HacksawItems.sharpChefKnife.item, 1, -1)//Note: a new itemstack is made here because you want to be able to use the item no matter what the damage value
			});
			
			//recipe for "sharpening" the Dull Chef knife
			ModLoader.addShapelessRecipe(new ItemStack(HacksawItems.sharpChefKnife.item), new Object[]{
				 HacksawItems.dullChefKnife.item, new ItemStack(HacksawItems.knifeSharpener.item, 1, -1)
			});
						
		
	}
	
	
	
}
