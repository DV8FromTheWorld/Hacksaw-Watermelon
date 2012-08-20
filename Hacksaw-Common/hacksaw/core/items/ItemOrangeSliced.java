package hacksaw.core.items;

public class ItemOrangeSliced extends ItemBaseFood{

	public ItemOrangeSliced(int par1, int foodHealAmount, float saturationAmount, boolean par4) {
		super(par1, foodHealAmount, saturationAmount, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(5, 0);
		this.setItemName("orange.sliced");
		this.foodHealAmount = foodHealAmount;
		this.saturationAmount = saturationAmount;		
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

}
