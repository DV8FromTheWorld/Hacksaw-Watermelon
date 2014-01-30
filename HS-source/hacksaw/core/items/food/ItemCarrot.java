package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemCarrot extends ItemBaseFood
{

    public ItemCarrot(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat)
    {
        super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("carrot");
        this.setTextureName("carrot");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }
}
