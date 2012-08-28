package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;

public abstract class ItemBaseFood extends ItemFood {
	
	public abstract boolean shouldRotateAroundWhenRendering();
	
	public ItemBaseFood(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, isWolfsFavoriteMeat);
		this.setTabToDisplayOn(CreativeTabs.tabFood);
	}
	
	@Override
	// To add the 'food.' string as a prefix to Hacksaw food items
	public Item setItemName(String itemName) {
		String newname = "food." + itemName;
		return super.setItemName(newname);
	}
	
	public ItemBaseFood(int id, int foodHealAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, isWolfsFavoriteMeat);
		this.setTabToDisplayOn(CreativeTabs.tabFood);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.eat;
    }
	
	@Override
	public String getTextureFile() {
		return "/hacksaw/textures/food.png";
	}
}
