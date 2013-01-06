package hacksaw.core.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemBaseChefTools extends Item{

	protected ItemBaseChefTools(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	
	@Override
	// To add the 'chef.' string as a prefix to Hacksaw chef tools
	public Item setItemName(String itemName) {
		String newname = "chef." + itemName;
		return super.setItemName(newname);
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
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
	}
}
