package hacksaw.core.items;

import net.minecraft.src.Block;
import hacksaw.core.HacksawBlocks;

public class ItemCarrotSeed extends ItemCropSeed {

	public ItemCarrotSeed(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setItemName("carrot.seed");
	}

	@Override
	public int getCropBlockID() {
		return HacksawBlocks.carrot.blockId;
	}

	@Override
	public int getSoilBlockID() {
		return Block.tilledField.blockID;
	}

}
