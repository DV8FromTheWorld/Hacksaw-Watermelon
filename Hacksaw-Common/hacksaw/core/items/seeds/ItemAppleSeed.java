package hacksaw.core.items.seeds;

import net.minecraft.src.Block;
import hacksaw.core.items.ItemCropSeed;

public class ItemAppleSeed extends ItemCropSeed{

	public ItemAppleSeed(int id, int blockId) {
		super(id, blockId, Block.dirt.blockID);
	}

}
