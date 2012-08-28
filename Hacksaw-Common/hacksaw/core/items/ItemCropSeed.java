package hacksaw.core.items;

import hacksaw.core.HacksawBlocks;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public abstract class ItemCropSeed extends ItemSeeds {

	public ItemCropSeed(int id, int blockId, int blockToGrowOnId) {
		super(id, blockId, blockToGrowOnId);
		this.setTabToDisplayOn(CreativeTabs.tabAllSearch);
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
