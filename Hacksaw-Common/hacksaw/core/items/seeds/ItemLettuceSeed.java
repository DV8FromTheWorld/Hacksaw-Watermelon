package hacksaw.core.items.seeds;

import net.minecraft.src.Block;
import hacksaw.core.HacksawBlocks;
import hacksaw.core.items.ItemCropSeed;

public class ItemLettuceSeed extends ItemCropSeed {

	public ItemLettuceSeed(int id, int blockId) {
		super(id, blockId);
		this.setMaxStackSize(64);
		this.setIconCoord(1, 0);
		this.setItemName("lettuce.seed");
	}
}
