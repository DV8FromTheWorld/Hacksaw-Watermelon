package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemAppleRedSliced extends ItemBaseFood
{

    public ItemAppleRedSliced(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat)
    {
        super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("apple.red.sliced");
        this.setTextureName("apple_slice");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

}
