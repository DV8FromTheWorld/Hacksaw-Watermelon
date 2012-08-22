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

	// number of steps in growth - vanilla wheat has 7  
	protected int growthStages = 7;
	// base growth rate - vanilla wheat is 1.0
	protected float baseGrowthRate = 1.0f;
	// minimum light for growth - vanilla wheat is 9
	protected float minLight = 9;
	
	protected BlockBaseCrop(int id, int blockIndexInTexture, int growthStages) {
		super(id, blockIndexInTexture);
		this.growthStages = growthStages;
	}
	
	public void setBaseGrowthRate( float growthRate ) {
		baseGrowthRate = growthRate;
	}
	
	@Override
	public void updateTick(World world, int x, int z, int y, Random rng) {
		// we don't want to call the base growth - because among other reasons it calls flower's growth, and likes to make things unspawn
		//super.updateTick(world, x, z, y, rng);

		// only grow if it's light
		if (world.getBlockLightValue(x, z + 1, y) >= this.minLight) {
			int growthLevel = world.getBlockMetadata(x, z, y);

			if (growthLevel < this.growthStages) {
				float growthRate = calculateGrowthRate(world, x, z, y);

				if (rng.nextInt((int) (25.0F / growthRate) + 1) == 0) {
					//System.out.println("growing to " + growthLevel);
					++growthLevel;
					world.setBlockMetadataWithNotify(x, z, y, growthLevel);
				}
			}
		}
	}
	
	/**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one).
     * 
     * NB: This method is directly adapted from the superclass with the exception that we provide a base rate to start with.
     *     We would just override the previous method but it is private for some rason.
     */
    protected float calculateGrowthRate(World world, int x, int z, int y)
    {
        float finalRate = this.baseGrowthRate;
        int n = world.getBlockId(x, z, y - 1);
        int s = world.getBlockId(x, z, y + 1);
        int e = world.getBlockId(x - 1, z, y);
        int w = world.getBlockId(x + 1, z, y);
        int ne = world.getBlockId(x - 1, z, y - 1);
        int nw = world.getBlockId(x + 1, z, y - 1);
        int sw = world.getBlockId(x + 1, z, y + 1);
        int se = world.getBlockId(x - 1, z, y + 1);

        for (int i = x - 1; i <= x + 1; ++i) {
            for (int j = y - 1; j <= y + 1; ++j) {
                int ground = world.getBlockId(i, z - 1, j);
                float bonus = 0.0F;

                // bonus points for adjacent soil
                if (ground == Block.tilledField.blockID) {
                    bonus = 1.0F;

                    // bonus points for hydrated soil
                    if (world.getBlockMetadata(i, z - 1, j) > 0) {
                        bonus = 3.0F;
                    }
                }

                // diagonal soil is only worth 25%
                if (i != x || j != y) {
                    bonus /= 4.0F;
                }

                finalRate += bonus;
            }
        }
        
        // 50% penalty if surrounded on any two sides
        
        boolean adjX = (e == this.blockID || w == this.blockID);
        boolean adjY = (n == this.blockID || s == this.blockID);
        boolean adjD = (ne == this.blockID || nw == this.blockID || sw == this.blockID || se == this.blockID);

        if (adjD || adjX && adjY) {
            finalRate /= 2.0F;
        }
        
        // TODO: add modifier for fertilizer/bonemeal

        return finalRate;
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
