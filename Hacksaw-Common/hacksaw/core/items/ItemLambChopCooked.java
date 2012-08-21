package hacksaw.core.items;

public class ItemLambChopCooked extends ItemBaseFood {

	public ItemLambChopCooked(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
		this.setMaxStackSize(64);
		this.setIconCoord(3, 0);
		this.setItemName("lamb.chop.cooked");
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
}
