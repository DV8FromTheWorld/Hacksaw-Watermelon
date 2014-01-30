package hacksaw.core.items.tools;

import hacksaw.core.items.ItemBaseChefTools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemKnifeSharpener extends ItemBaseChefTools
{

    public ItemKnifeSharpener(int id)
    {
        super(id);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("knife.sharpener");
        this.setTextureName("test_face");
    }

    @Override
    public Item getContainerItem()
    {
        return this;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
        return true;
    }
}
