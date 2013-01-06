package hacksaw.core.machines;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
		
//This was just for testing, does nothing yet.

public class GrillRecipes{

	public static HashMap<Integer,ItemStack> foodCookList = new HashMap<Integer,ItemStack>();
	public static HashMap<Integer,Integer> durationToCookFood = new HashMap<Integer,Integer>();
	private static final GrillRecipes INSTANCE = new GrillRecipes();	
	
	private GrillRecipes(){	
		
	}		
	
	/*
	 * Use this to access methods within the API class
	 * Ex: GrillRecipes.getInstance().addToGrillToCook	 * 
	 */	 
	public static GrillRecipes getInstance(){
		return INSTANCE;
	}
	
	/*
	 * Use this method to be able to cook something on the grill.  
	 * This uses the default "cooking" time.
	 * 
	 * @param input: ID of the item to be "cooked" (Note, this needs to be the shiftedIndex ID)
	 * @param output: the "cooked" version of the item
	 */
	public static void addToGrillToCook(int input, ItemStack output){
		addToGrillToCook(input, output, -1);
	}

	/*
	 * Use this method to be able to cook something on the grill.  
	 * This method allows specifying an amount of time to cook the item.
	 * 
	 * @param input: ID of the item to be "cooked" (Note, this needs to be the shiftedIndex ID)
	 * @param output: the "cooked" version of the item
	 * @param cookTime: amount of time needed to cook the item (in seconds)
	 */
	public static void addToGrillToCook(int input, ItemStack output, int cookTime){
		//----Temp---
		ModLoader.addSmelting(input, output);
		//----/Temp---
		foodCookList.put(input, output);
		durationToCookFood.put(input, cookTime);
	}
	
	public HashMap<Integer,ItemStack> getFoodToCook(){
		return foodCookList;
	}
	
	public HashMap<Integer,Integer> getDurationToCook(){
		return durationToCookFood;
	}

}	
