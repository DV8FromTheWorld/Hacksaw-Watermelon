package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleGreen extends ItemBaseFood
{

	public ItemAppleGreen(int id, int foodHealAmount, float saturationAmount,
			boolean isWolfsFavoriteMeat)
	{
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("apple.green");
		this.setTextureName("apple_green");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering()
	{
		return false;
	}

}
