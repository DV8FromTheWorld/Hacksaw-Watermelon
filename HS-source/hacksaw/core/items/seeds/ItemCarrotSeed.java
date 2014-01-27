package hacksaw.core.items.seeds;

import hacksaw.core.items.ItemCropSeed;

public class ItemCarrotSeed extends ItemCropSeed
{

	public ItemCarrotSeed(int id, int blockId)
	{
		super(id, blockId);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("carrot.seed");
		this.setTextureName("seeds1");
	}
}
