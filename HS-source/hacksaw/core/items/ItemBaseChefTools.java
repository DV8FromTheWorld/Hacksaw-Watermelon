package hacksaw.core.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemBaseChefTools extends Item
{

	protected ItemBaseChefTools(int id)
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	// To add the 'chef.' string as a prefix to Hacksaw chef tools
	public Item setUnlocalizedName(String itemName)
	{
		String newname = "chef." + itemName;
		return super.setUnlocalizedName(newname);
	}

	@Override
	public abstract boolean shouldRotateAroundWhenRendering();

	@Override
	public abstract boolean doesContainerItemLeaveCraftingGrid(
			ItemStack itemstack);

	@Override
	public Item setNoRepair()
	{
		return this;
	}

	@Override
	public boolean isRepairable()
	{
		return false;
	}
}
