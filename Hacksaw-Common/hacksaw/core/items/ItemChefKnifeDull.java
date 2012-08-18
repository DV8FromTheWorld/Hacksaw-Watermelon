package hacksaw.core.items;

import net.minecraft.src.ItemStack;

public class ItemChefKnifeDull extends ItemBaseChefTools {
	
	public ItemChefKnifeDull(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
		this.setIconCoord(0, 0);
		this.setItemName("dull.chef.knife");
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

