package hacksaw.core.items.tools;

import hacksaw.core.items.ItemBaseChefTools;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

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
