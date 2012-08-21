package hacksaw.core.items;

public class ItemAppleSliced extends ItemBaseFood{

	public ItemAppleSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(6, 0);
		this.setItemName("apple.sliced");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

}
