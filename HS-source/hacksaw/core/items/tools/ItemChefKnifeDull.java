package hacksaw.core.items.tools;

import hacksaw.core.items.ItemBaseChefTools;
import net.minecraft.item.ItemStack;

public class ItemChefKnifeDull extends ItemBaseChefTools
{

    public ItemChefKnifeDull(int id)
    {
        super(id);
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
        this.setUnlocalizedName("knife.dull");
        this.setTextureName("chef_knife");
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
        return false;
    }
}
