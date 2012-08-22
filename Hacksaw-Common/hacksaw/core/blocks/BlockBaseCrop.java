package hacksaw.core.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCrops;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.forge.IBonemealHandler;
import net.minecraft.src.forge.ITextureProvider;

public abstract class BlockBaseCrop extends BlockCrops implements IBonemealHandler {

	protected int growthStages;
	
	protected BlockBaseCrop(int id, int blockIndexInTexture, int growthStages) {
		super(id, blockIndexInTexture);
		this.growthStages = growthStages;
	}
	
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        if (meta < 0 || meta > this.growthStages) {
            meta = this.growthStages;
        }

        return this.blockIndexInTexture + meta;
    }
	
	public abstract int getRenderType();
	public abstract ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune);
	public abstract int idDropped(int par1, Random par2Random, int par3);
	public abstract int quantityDropped(Random par1Random);
	
	@Override
	public Block setBlockName(String name) {
		String newname = "crop." + name;
		return super.setBlockName(newname);
	}
	
	public String getTextureFile() {
		return "/hacksaw/textures/crops.png";
	}

	@Override
	public boolean onUseBonemeal(World world, int blockID, int X, int Y, int Z) {
		return false;
	}

}
