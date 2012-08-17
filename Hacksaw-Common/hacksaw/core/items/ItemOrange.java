package hacksaw.core.items;

public class ItemOrange extends ItemBaseFood{

	public ItemOrange(int par1, int foodHealAmount, float saturationAmount, boolean par4) {
		super(par1, foodHealAmount, saturationAmount, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(4, 0);
		this.setItemName("orange");
		this.foodHealAmount = foodHealAmount;
		this.saturationAmount = saturationAmount;
	}

}
