package hacksaw.core.items;

import hacksaw.core.HacksawBlocks;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;

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
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
	
	@Override
	public String getTextureFile(){
		return "/hacksaw/textures/seeds.png";
	}

}
