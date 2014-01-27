package hacksaw.core.items.tools;

import hacksaw.core.items.ItemBaseChefTools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemChefKnifeSharp extends ItemBaseChefTools
{

	public ItemChefKnifeSharp(int id)
	{
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(45);
		this.setUnlocalizedName("knife.sharp");
		this.setTextureName("chef_knife");
		// this.setIconCoord(0, 0);
	}

	@Override
	public Item getContainerItem()
	{
		return this;
	}

	@Override
	public boolean shouldRotateAroundWhenRendering()
	{
		return true;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
	{
		return false;
	}
}
