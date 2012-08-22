package hacksaw.core.items;

import net.minecraft.src.Block;
import hacksaw.core.HacksawBlocks;

public class ItemCarrotSeed extends ItemCropSeed {

	public ItemCarrotSeed(int id) {
		super(id, HacksawBlocks.carrot.blockId, Block.tilledField.blockID);
		this.setMaxStackSize(64);
		this.setItemName("carrot.seed");
	}
}
