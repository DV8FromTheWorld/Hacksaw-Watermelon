package hacksaw.core.items.food;

import hacksaw.core.items.ItemBaseFood;

public class ItemOrangeSliced extends ItemBaseFood
{

    public ItemOrangeSliced(int par1, int foodHealAmount, float saturationAmount, boolean par4)
    {
        super(par1, foodHealAmount, saturationAmount, par4);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("orange.slices");
        this.setTextureName("orange_slices");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

}
