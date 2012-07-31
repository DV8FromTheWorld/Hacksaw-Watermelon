package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemDullChefKnife extends Item implements ITextureProvider{
	
	public ItemDullChefKnife(int i) {
		super(i);
		this.setMaxStackSize(8);
		this.setMaxDamage(0);
	}
	

	public boolean shouldRotateAroundWhenRendering(){
		return true;
	}
	
	
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
		
	}
	
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
}

