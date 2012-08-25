package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleGreenSliced extends ItemBaseFood{

	public ItemAppleGreenSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(8, 0);
		this.setItemName("apple.green.sliced");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

}
