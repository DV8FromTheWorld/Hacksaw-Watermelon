package hacksaw.core.items;

import net.minecraft.src.Block;
import hacksaw.core.HacksawBlocks;

public class ItemCarrotSeed extends ItemCropSeed {

	public ItemCarrotSeed(int id, int blockId) {
		super(id, blockId);
		this.setMaxStackSize(64);
		this.setItemName("carrot.seed");
	}
}
