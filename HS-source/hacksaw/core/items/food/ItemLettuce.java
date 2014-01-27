package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemLettuce extends ItemBaseFood
{

	public ItemLettuce(int id, int foodHealAmount, float saturationAmount,
			boolean isWolfsFavoriteMeat)
	{
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("lettuce");
		this.setTextureName("lettuce");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering()
	{
		return false;
	}
}
