package hacksaw.core;

import hacksaw.core.items.ItemChefKnife;
import hacksaw.core.util.CoreConfiguration;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Test {
	
	public static void registerItemsAndBlocks(){
		//Registers blocks and there specifics (blockID, harvest level, etc)
			//TODO for when we add blocks
		
		//Registers the Items and there specifics (itemID, Texture placement, etc)
		HacksawItems.chefKnife.item = new ItemChefKnife(HacksawItems.chefKnife.itemId).setIconIndex(1).setItemName("Chef.Knife");
		
		
		//Registers the names for the blocks
			//TODO for when we add blocks
		
		
		//Registers the names for the items
		ModLoader.addName(HacksawItems.chefKnife.item, "Chef Knife");
		
		//Registers the shaped-recipes for items
			//TODO for items
		
		
		//Registers the shapeless-recipes for items
			/*
			 * Ignore this, i was testing something.
			 * 	ModLoader.addShapelessRecipe(, new Object[]{
							Item.diamond, new ItemStack(HacksawItems.chefKnife.item, 1, -1)
				});  */
		
		
	}
	
	
	
}
