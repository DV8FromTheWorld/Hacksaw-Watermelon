package hacksaw.core.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public abstract class ItemCropSeed extends ItemSeeds {

	public ItemCropSeed(int id, int blockId, int blockToGrowOnId) {
		super(id, blockId, blockToGrowOnId);
	}
	
	// by default assume crops grow on tilled soil
	public ItemCropSeed(int id, int blockId) {
		this(id, blockId, Block.tilledField.blockID);
	}

	@Override
	public Item setItemName(String name) {
		String newname = "crop." + name;
		return super.setItemName(newname);
	}

	
	@Override
	public String getTextureFile(){
		return "/hacksaw/textures/seeds.png";
	}

}
