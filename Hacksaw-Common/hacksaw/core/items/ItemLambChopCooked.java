package hacksaw.core.items;

public class ItemLambChopCooked extends ItemBaseFood {

	public ItemLambChopCooked(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(3, 0);
		this.setItemName("lamb.chop.cooked");
		this.foodHealAmount = par2;
		this.saturationAmount = par3;
	}
}
