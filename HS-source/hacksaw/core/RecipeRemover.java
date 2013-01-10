package hacksaw.core;

import hacksaw.core.util.CoreConfiguration;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.HacksawLogger.LogLevel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {

	// set of recipes to remove
	private static Set<Integer> recipeSet = new HashSet<Integer>();

	private static void flushItems() {
		recipeSet.clear();
	}
	
	public static void registerItemRecipeToRemove(Object object) {
		// Checks if object being parsed is a Block or an Item and adds to the Set accordingly
		
		if (object instanceof Block) {
			recipeSet.add(((Block) object).blockID);
		}
		if (object instanceof Item) {
			recipeSet.add(((Item) object).itemID);
		}
	}

	// set of smelting recipes to remove
	private static Set<Integer> smeltingSet = new HashSet<Integer>();

	private static void flushSmelting() {
		smeltingSet.clear();
	}

	public static void registerItemSmeltingToRemove(Object object) {
		// Checks if object being parsed is a Block or an Item and adds to the Set accordingly
		
		if (object instanceof Block) {
			smeltingSet.add(((Block) object).blockID);
		}
		if (object instanceof Item) {
			smeltingSet.add(((Item) object).itemID);
		}
	}

	private static void removeCrafting() {

		// remove everything from the list
		@SuppressWarnings("unchecked")
		List<IRecipe> recipes = CraftingManager
				.getInstance()
					.getRecipeList();
		Iterator<IRecipe> it = recipes.iterator();
		List<IRecipe> matches = new ArrayList<IRecipe>(); // recipes to remove
		while (it.hasNext()) {
			IRecipe recipe = it.next();
			ItemStack output = recipe.getRecipeOutput();
			if (output != null && recipeSet.contains(output.itemID)) {
				matches.add(recipe);
			}
		}
		for (IRecipe recipe : matches) {
			HacksawLogger.log(LogLevel.INFO, "Removing recipe for " + recipe);
			recipes.remove(recipe);
		}
		flushItems();
	}

	private static void removeSmelting() {
		// TODO: repeat above but with FurnaceRecipes
		flushSmelting();
	}

	public static void removeVanillaRecipes() {
		if (CoreConfiguration
				.getPreference(CoreConfiguration.USE_VANILLA_RECIPES) == false) {
			HacksawLogger.log(LogLevel.DEBUG, "Registering recipes to remove");
			registerItemRecipeToRemove(Item.bread.itemID);

			HacksawLogger.log(LogLevel.DEBUG, "Removing vanilla recipes");
			removeCrafting();
			removeSmelting();
		}
	}
}
