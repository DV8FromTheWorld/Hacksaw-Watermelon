package hacksaw.core.items.seeds;

import hacksaw.core.items.ItemCropSeed;
import net.minecraft.block.Block;

public class ItemAppleSeed extends ItemCropSeed
{

    public ItemAppleSeed(int id, int blockId)
    {
        super(id, blockId, Block.dirt.blockID);
        this.setUnlocalizedName("apple.seed");
        this.setTextureName("seeds3");
    }

}
