package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemCarrotSliced extends ItemBaseFood{
	
	public ItemCarrotSliced(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(1, 0);
		this.setItemName("carrot.sliced");
		this.foodHealAmount = par2;
		this.saturationAmount = par3;
	}
}
