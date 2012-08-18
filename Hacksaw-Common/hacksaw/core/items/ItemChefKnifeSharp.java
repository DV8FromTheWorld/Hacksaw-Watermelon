package hacksaw.core.items;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemChefKnifeSharp extends ItemBaseChefTools {
	
	public ItemChefKnifeSharp(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(45);
		this.setItemName("sharp.chef.knife");
		this.setIconCoord(0, 0);
	}

	@Override
	public Item getContainerItem(){
		return this;
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;
	}
}
