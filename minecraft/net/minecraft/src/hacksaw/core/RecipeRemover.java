package net.minecraft.src.hacksaw.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class RecipeRemover {
	
	public static void removeVanillaRecipes(){
		if(CoreConfiguration.getPreference(CoreConfiguration.USE_VANILLA_RECIPES) == false){
			ModLoader.getLogger().fine("[Hacksaw] Removing vanilla recipes");
			removeCrafting();
			removeSmelting();
		}	
	}

	private static void removeCrafting() {
		// set of recipes to remove
		Set<Integer> itemSet = new HashSet<Integer>();
		itemSet.add(Item.bread.shiftedIndex);
		
		// remove everything from the list
		List<IRecipe> recipes = (List)CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> it = recipes.iterator();
		List<IRecipe> matches = new ArrayList<IRecipe>();	// recipes to remove
		while( it.hasNext() ) {
			IRecipe recipe = it.next();
			ItemStack output = recipe.getRecipeOutput();
			if( itemSet.contains(output.itemID)) {
				matches.add(recipe);
			}
		}
		for( IRecipe recipe : matches ) {
			ModLoader.getLogger().finer("[Hacksaw] Removing recipe for "+recipe);
			recipes.remove(recipe);
		}
	}
		
	private static void removeSmelting() {
		// TODO: repeat above but with FurnaceRecipes
	}
	
}
