package hacksaw.core.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public abstract class ItemBaseFood extends ItemFood
{

	public abstract boolean shouldRotateAroundWhenRendering();

	public ItemBaseFood(int id, int foodHealAmount, float saturationAmount,
			boolean isWolfsFavoriteMeat)
	{
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	// To add the 'food.' string as a prefix to Hacksaw food items
	public Item setUnlocalizedName(String itemName)
	{
		String newname = "food." + itemName;
		return super.setUnlocalizedName(newname);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.eat;
	}

	@Override
	public Item setTextureName(String name)
	{
		super.setTextureName("hacksaw:" + name);
		return this;
	}

	// @Override
	// public String getTextureFile() {
	// return "/hacksaw/textures/food.png";
	// }
}
