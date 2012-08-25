package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleGreen extends ItemBaseFood{

	public ItemAppleGreen(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setIconCoord(7, 0);
		this.setMaxStackSize(64);
		this.setItemName("apple.green");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
	

}
