package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleGreenSliced extends ItemBaseFood
{

    public ItemAppleGreenSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat)
    {
        super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("apple.green.slice");
        this.setTextureName("apple_green_slice");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

}
