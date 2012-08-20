package hacksaw.core.items;

public class ItemAppleSliced extends ItemBaseFood{

	public ItemAppleSliced(int par1, int foodHealAmount, float saturationAmount, boolean par4) {
		super(par1, foodHealAmount, saturationAmount, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(6, 0);
		this.setItemName("apple.sliced");
		this.foodHealAmount = foodHealAmount;
		this.saturationAmount = saturationAmount;
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

}
