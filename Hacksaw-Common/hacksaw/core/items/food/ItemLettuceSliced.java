package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemLettuceSliced extends ItemBaseFood {
	
	public ItemLettuceSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(1, 0);
		this.setItemName("lettuce.sliced");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
}
