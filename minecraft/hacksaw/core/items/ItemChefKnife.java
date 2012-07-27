package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemChefKnife extends Item implements ITextureProvider{

	//public int Sharpness;
	
	public ItemChefKnife(int i) {
		super(i);
		this.setMaxStackSize(1);
		
		//Sharpness = j;
	}
	
	/*public int getKnifeSharpness(){
		return Sharpness;
	}*/

	public boolean shouldRotateAroundWhenRendering(){
		return true;
	}
	
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
		
	}
	
	public Item getContainerItem(){
		return this;
		
	}
	
	public boolean doesContainerItemLeaveCraftingGrid(){
		return false;
	}
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
}
