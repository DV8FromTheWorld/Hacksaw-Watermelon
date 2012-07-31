package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemKnifeSharpener extends Item{

	public ItemKnifeSharpener(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(10);
		this.setIconIndex(1);
		this.setItemName("knife.sharpener");
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
