package hacksaw.core;

import hacksaw.core.items.ItemDullChefKnife;
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
		
		
		//Registers the Items and there specifics (itemID, Texture placement, etc)
		HacksawItems.sharpChefKnife.item = new ItemSharpChefKnife(HacksawItems.sharpChefKnife.itemId).setIconIndex(1).setItemName("sharp.chef.knife");
		HacksawItems.dullChefKnife.item = new ItemDullChefKnife(HacksawItems.dullChefKnife.itemId).setIconIndex(0).setItemName("dull.chef.knife");
		
		
		
		//Registers the names for the blocks
			//TODO for when we add blocks
		
		
		
		//Registers the names for the items
		ModLoader.addName(HacksawItems.sharpChefKnife.item, "Chef Knife");
		ModLoader.addName(HacksawItems.dullChefKnife.item, "Dull Chef Knife");
		
		//Registers the shaped-recipes for items
			//TODO for items
		
		
		
		//Registers the shapeless-recipes for items
			ModLoader.addShapelessRecipe(new ItemStack(Item.melon, 5), new Object[]{
				Block.melon, new ItemStack(HacksawItems.sharpChefKnife.item, 1, -1)
			});
		
	}
	
	
	
}
