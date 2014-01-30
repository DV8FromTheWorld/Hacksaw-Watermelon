package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemOrange extends ItemBaseFood
{

    public ItemOrange(int par1, int foodHealAmount, float saturationAmount, boolean par4)
    {
        super(par1, foodHealAmount, saturationAmount, par4);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("orange");
        this.setTextureName("orange");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

}
