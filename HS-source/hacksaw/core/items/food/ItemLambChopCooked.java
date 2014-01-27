package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemLambChopCooked extends ItemBaseFood
{

	public ItemLambChopCooked(int id, int foodHealAmount,
			float saturationAmount, boolean isWolfsFavoriteMeat)
	{
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("lamb.chop.cooked");
		this.setTextureName("porkchop_cooked");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering()
	{
		return false;
	}
}
