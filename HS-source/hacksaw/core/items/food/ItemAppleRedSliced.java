package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleRedSliced extends ItemBaseFood{

	public ItemAppleRedSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(6, 0);
		this.setItemName("apple.red.sliced");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

}
