package hacksaw.core.items.seeds;

import hacksaw.core.items.ItemCropSeed;

public class ItemLettuceSeed extends ItemCropSeed
{

    public ItemLettuceSeed(int id, int blockId)
    {
        super(id, blockId);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("lettuce.seed");
        this.setTextureName("seeds2");
    }
}
