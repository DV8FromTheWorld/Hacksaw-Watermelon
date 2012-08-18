package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemBaseSeed extends ItemSeeds implements ITextureProvider{

	public ItemBaseSeed(int par1, int par2, int par3) {
		super(par1, par2, par3);
		
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
