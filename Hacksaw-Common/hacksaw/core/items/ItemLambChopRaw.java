package hacksaw.core.items;

public class ItemLambChopRaw extends ItemBaseFood {

	public ItemLambChopRaw(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(2, 0);
		this.setItemName("lamb.chop.raw");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
}
