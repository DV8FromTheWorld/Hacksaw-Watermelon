package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemChefKnifeDull extends Item implements ITextureProvider{
	
	public ItemChefKnifeDull(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
		this.setIconCoord(0, 0);
		this.setItemName("dull.chef.knife");
	}
	

	public boolean shouldRotateAroundWhenRendering(){
		return true;
	}
	
	
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
		
	}
	
	public Item setNoRepair(){
		return this;
	}
	
	public boolean isRepairable(){
		return false;
	}
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
}

