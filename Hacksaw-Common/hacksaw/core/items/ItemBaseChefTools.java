package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemBaseChefTools extends Item implements ITextureProvider {

	protected ItemBaseChefTools(int par1) {
		super(par1);
	}
	
	public abstract boolean shouldRotateAroundWhenRendering();
	public abstract boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack);
	
	@Override
	public Item setNoRepair() {
		return this;
	}
	
	@Override
	public boolean isRepairable() {
		return false;
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
