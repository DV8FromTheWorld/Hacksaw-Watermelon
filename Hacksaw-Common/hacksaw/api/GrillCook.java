package hacksaw.api;

import java.lang.reflect.Method;

import net.minecraft.src.ItemStack;



public class GrillCook {
	
	private static GrillCook INSTANCE = new GrillCook();
		
	private GrillCook(){
		
	}
	
	
	/*
	 * Use this to access methods within this API class
	 * Ex: GrillCook.getInstance().addToGrillToCook	 * 
	 */
	public static GrillCook getInstance(){
		return INSTANCE;		
	}
	
	/*
	 * Use this method to be able to cook something on the grill.  
	 * This uses the default "cooking" time.
	 * 
	 * @param input: ID of the item to be "cooked" (Note, this needs to be the shiftedIndex ID)
	 * @param output: the "cooked" version of the item
	 */
	public void addToGrillToCook(int input, ItemStack output){
		try{
			Class GrillCookRecipes = Class.forName("hacksaw.core.machines.GrillRecipes");
			Method addNewFood = GrillCookRecipes.getMethod("addToGrillToCook", new Class[]{ Integer.TYPE, ItemStack.class});
			addNewFood.invoke(null, new Object[]{
					input, output
			});
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * Use this method to be able to cook something on the grill.  
	 * This method allows specifying an amount of time to cook the item.
	 * 
	 * @param input: ID of the item to be "cooked" (Note, this needs to be the shiftedIndex ID)
	 * @param output: the "cooked" version of the item
	 * @param cookTime: amount of time needed to cook the item (in seconds)
	 */
	public void addToGrillToCook(int input, ItemStack output, int cookTime){
		try{	
			Class GrillCookRecipes = Class.forName("hacksaw.core.machines.GrillRecipes");
			Method addNewFood = GrillCookRecipes.getMethod("addToGrillToCook", new Class[]{ Integer.TYPE, ItemStack.class, Integer.TYPE});
			addNewFood.invoke(null, new Object[]{
					input, output, cookTime
			});
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
}
