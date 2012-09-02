package hacksaw.core.items.seeds;

import net.minecraft.src.Block;
import hacksaw.core.HacksawBlocks;
import hacksaw.core.items.ItemCropSeed;

public class ItemCarrotSeed extends ItemCropSeed {

	public ItemCarrotSeed(int id, int blockId) {
		super(id, blockId);
		this.setMaxStackSize(64);
		this.setIconCoord(0, 0);
		this.setItemName("carrot.seed");
	}
}
