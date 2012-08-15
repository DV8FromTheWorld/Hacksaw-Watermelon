package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public class ItemLambChopRaw extends ItemFood implements ITextureProvider{
	
	public int foodHealAmount;
	public float saturationAmount;


	public ItemLambChopRaw(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setMaxStackSize(64);
		this.setIconCoord(2, 0);
		this.setItemName("lamb.chop.raw");
		par2 = foodHealAmount;
		par3 = saturationAmount;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.eat;
    }
	
	public int getHealAmount()
    {
        return foodHealAmount;
    }
	
	public float getSaturationModifier()
    {
        return saturationAmount;
    }
	
	public String getTextureFile(){
		return "/hacksaw/textures/food.png";
	}
	
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}

}
