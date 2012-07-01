package net.minecraft.src.Hacksaw.Core;

public class RecipeRemover {

	
	public static void removeVanillaRecipes(){
		if(CoreConfiguration.useVanillaRecipes == false){
			System.out.println("hi, ill be removing the recipes now."); //placeholder for testing
			removeCrafting();
			removeSmelting();
		}
		
	}

	private static void removeCrafting() {
		System.out.println("hi, i removed crafting"); //placeholder for testing
		//Code for removing the crafting of certain food recipes goes here
	}
		
	
		
	private static void removeSmelting() {
		System.out.println("hi, i removed smelting"); //placeholder for testing
		//Code for removing food and other things from being made in the furnace goes here
	}
	
	
}
