package hacksaw.core.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import hacksaw.core.items.ItemBaseChefTools;

public class ItemChefKnifeSharp extends ItemBaseChefTools {
	
	public ItemChefKnifeSharp(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(45);
		this.setItemName("knife.sharp");
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
