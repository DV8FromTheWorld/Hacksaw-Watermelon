package hacksaw.core;

import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.HacksawLogger.LogLevel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class RecipeRemover {
	
	// set of recipes to remove
	private static Set<Integer> recipeSet = new HashSet<Integer>();
	
	public static void registerItemRecipeToRemove(Object object) {
		if (object instanceof Block) {
			recipeSet.add(((Block)object).blockID);
		}
		if (object instanceof Item) {
			recipeSet.add(((Item)object).shiftedIndex);
		}
	}
	
	// set of recipes to remove
	private static Set<Integer> smeltingSet = new HashSet<Integer>();
	
	public static void registerItemSmeltingToRemove(Object object) {
		if (object instanceof Block) {
			smeltingSet.add(((Block)object).blockID);
		}
		if (object instanceof Item) {
			smeltingSet.add(((Item)object).shiftedIndex);
		}
	}
	
	private static void removeCrafting() {
		
		// remove everything from the list
		List<IRecipe> recipes = (List)CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> it = recipes.iterator();
		List<IRecipe> matches = new ArrayList<IRecipe>();	// recipes to remove
		while( it.hasNext() ) {
			IRecipe recipe = it.next();
			ItemStack output = recipe.getRecipeOutput();
			if( recipeSet.contains(output.itemID)) {
				matches.add(recipe);
			}
		}
		for( IRecipe recipe : matches ) {
			ModLoader.getLogger().info("Removing recipe for "+recipe);
			recipes.remove(recipe);
		}
	}
	
	private static void removeSmelting() {
		// TODO: repeat above but with FurnaceRecipes
	}
	
	public static void removeVanillaRecipes(){
		if(CoreConfiguration.getPreference(CoreConfiguration.USE_VANILLA_RECIPES) == false){
			HacksawLogger.log(LogLevel.DEBUG, "Registering recipes to remove");
			registerItemRecipeToRemove(Item.bread.shiftedIndex);
			
			HacksawLogger.log(LogLevel.DEBUG, "Removing vanilla recipes");
			removeCrafting();
			removeSmelting();
		}	
	}
}
