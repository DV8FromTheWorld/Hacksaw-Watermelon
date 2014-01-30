package hacksaw.core.items.food;

import hacksaw.api.IGrillable;
import hacksaw.core.HacksawItems;
import hacksaw.core.items.ItemBaseFood;

public class ItemLambChopRaw extends ItemBaseFood implements IGrillable
{

    public ItemLambChopRaw(int id, int foodHealAmount, float saturationAmount, boolean isWolfsFavoriteMeat)
    {
        super(id, foodHealAmount, saturationAmount, isWolfsFavoriteMeat);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("lamb.chop.raw");
        this.setTextureName("porkchop_raw");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

    @Override
    public int getCookingTime()
    {
        return -1;
    }

    @Override
    public int getCookedItemId()
    {
        return HacksawItems.lambChopCooked.item.itemID;
    }

}
