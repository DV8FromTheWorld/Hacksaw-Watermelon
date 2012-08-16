package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

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
