package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemBaseFood extends ItemFood implements ITextureProvider {
	
	protected int foodHealAmount;
	protected float saturationAmount;
	
	public abstract boolean shouldRotateAroundWhenRendering();
	
	public ItemBaseFood(int par1, int foodHealAmount, float saturationAmount, boolean par4) {
		super(par1, foodHealAmount, saturationAmount, par4);
	}
	
	public ItemBaseFood(int par1, int foodHealAmount, boolean par3) {
		super(par1, foodHealAmount, par3);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.eat;
    }
	
	@Override
	public int getHealAmount() {
		return this.foodHealAmount;
	}
	
	@Override
	public float getSaturationModifier() {
		return this.saturationAmount;
	}
	
	@Override
	public void addCreativeItems(ArrayList itemList) {
		itemList.add(new ItemStack(this, 1));
	}
	
	@Override
	public String getTextureFile() {
		return "/hacksaw/textures/food.png";
	}
}
