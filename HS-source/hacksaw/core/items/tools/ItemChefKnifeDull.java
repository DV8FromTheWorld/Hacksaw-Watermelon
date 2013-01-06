package hacksaw.core.items.tools;

import net.minecraft.item.ItemStack;
import hacksaw.core.items.ItemBaseChefTools;

public class ItemChefKnifeDull extends ItemBaseChefTools {
	
	public ItemChefKnifeDull(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
		this.setIconCoord(0, 0);
		this.setItemName("knife.dull");
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

