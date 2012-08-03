package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemChefKnifeSharp extends Item implements ITextureProvider{
	
	public ItemChefKnifeSharp(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(45);
		this.setItemName("sharp.chef.knife");
		this.setIconIndex(0);
	}
	

	public boolean shouldRotateAroundWhenRendering(){
		return true;
	}
	
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
		
	}
	
	public Item getContainerItem(){
		return this;
		
	}
	
	public Item setNoRepair(){
		return this;
	}
	
	public boolean isRepairable(){
		return false;
	}
	
	public boolean doesContainerItemLeaveCraftingGrid(){
		return false;
	}
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
}
