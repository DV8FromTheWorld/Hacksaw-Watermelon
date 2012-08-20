package hacksaw.core.items;

public class ItemCarrot extends ItemBaseFood{

	public ItemCarrot(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(0, 0);
		this.setItemName("carrot");
		foodHealAmount = par2;
		saturationAmount = par3;
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}
}
