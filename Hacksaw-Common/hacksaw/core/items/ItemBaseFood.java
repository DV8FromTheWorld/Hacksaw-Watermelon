package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemBaseFood extends ItemFood implements ITextureProvider {
	
	public abstract boolean shouldRotateAroundWhenRendering();
	
	public ItemBaseFood(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, isWolfsFavoriteMeat);
	}
	
	@Override
	// To add the 'food.' string as a prefix to Hacksaw food items
	public Item setItemName(String itemName) {
		String newname = "food." + itemName;
		return super.setItemName(newname);
	}
	
	public ItemBaseFood(int id, int foodHealAmount, boolean isWolfsFavoriteMeat) {
		super(id, foodHealAmount, isWolfsFavoriteMeat);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.eat;
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
