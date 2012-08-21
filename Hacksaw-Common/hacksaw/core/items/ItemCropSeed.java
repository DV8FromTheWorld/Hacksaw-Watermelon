package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemCropSeed extends Item implements ITextureProvider{

	public ItemCropSeed(int par1) {
		super(par1);
		
	}
	
	@Override
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
	
	@Override
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
	}

}
