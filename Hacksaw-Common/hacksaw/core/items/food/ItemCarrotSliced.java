package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemCarrotSliced extends ItemBaseFood {
	
	public ItemCarrotSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(1, 0);
		this.setItemName("carrot.sliced");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
}
