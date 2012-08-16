package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;

public abstract class ItemBaseFood extends ItemFood{
		
	public ItemBaseFood(int par1, int foodHealAmount, float saturationAmount, boolean par4) {
		super(par1, foodHealAmount, saturationAmount, par4);
	
	}	
	public ItemBaseFood(int par1, int foodHealAmount, boolean par3) {
		super(par1, foodHealAmount, par3);
	}
	
	public abstract EnumAction getItemUseAction(ItemStack par1ItemStack);
		
	public abstract String getTextureFile();
	
	public abstract int getHealAmount();
	
	public abstract float getSaturationModifier();
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
}
