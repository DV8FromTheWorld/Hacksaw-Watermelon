package hacksaw.core.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class BlockBaseCrop extends BlockCrops
{
	// set on metadata to determine bonemeal state
	protected static final int BIT_BONEMEAL = 0xF0;

	// number of steps in growth - vanilla wheat has 7
	protected int growthStages = 7;
	// base growth rate - vanilla wheat is 1.0
	protected float baseGrowthRate = 1.0f;
	// minimum light for growth - vanilla wheat is 9
	protected float minLight = 9;

	protected BlockBaseCrop(int id, int blockIndexInTexture, int growthStages)
	{
		super(id);
		this.growthStages = growthStages;
		this.setTickRandomly(true);
	}

	public void setBaseGrowthRate(float growthRate)
	{
		baseGrowthRate = growthRate;
	}

	public void setMinLight(int minLight)
	{
		if (minLight < 0)
			minLight = 0;
		if (minLight > 15)
			minLight = 15;
		this.minLight = minLight;
	}

	protected boolean isBonemealed(int meta)
	{
		return (meta & BIT_BONEMEAL) == BIT_BONEMEAL;
	}

	protected int getGrowthLevel(int meta)
	{
		return meta & ~BIT_BONEMEAL;
	}

	@Override
	public void updateTick(World world, int x, int z, int y, Random rng)
	{
		/**
		 * under no circumstances should we call super's updateTick() method:
		 * - It contains largely identical logic, this means two ticks every
		 * tick
		 * - It inherits behavior from flowers, which have a chance to unspawn
		 * in low light
		 * 
		 * //super.updateTick(world, x, z, y, rng);
		 */

		// only grow if it's light
		if (world.getBlockLightValue(x, z + 1, y) >= this.minLight)
		{
			final int meta = world.getBlockMetadata(x, z, y);
			final int growthLevel = getGrowthLevel(meta);
			final boolean bonemeal = isBonemealed(meta);

			if (growthLevel < this.growthStages)
			{
				final float growthRate = calculateGrowthRate(world, x, z, y,
						bonemeal);

				if (rng.nextInt((int) (25.0F / growthRate) + 1) == 0)
				{
					// it is safe to simply increment meta
					world.setBlockMetadataWithNotify(x, z, y, meta + 1, 1);
					// para5 might need to be 2. Test to see that crop updates
					// on the client
				}
			}
		}
	}

	/**
	 * Gets the growth rate for the crop. Setup to encourage rows by halving
	 * growth rate if there is diagonals, crops on
	 * different sides that aren't opposing, and by adding growth for every crop
	 * next to this one (and for crop below
	 * this one).
	 * 
	 * NB: This method is directly adapted from the superclass with the
	 * exception that we provide a base rate to start with.
	 * We would just override the previous method but it is private for some
	 * rason.
	 */
	protected float calculateGrowthRate(World world, int x, int z, int y,
			boolean bonemeal)
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

		for (int i = x - 1; i <= x + 1; ++i)
		{
			for (int j = y - 1; j <= y + 1; ++j)
			{
				int ground = world.getBlockId(i, z - 1, j);
				float bonus = 0.0F;

				// bonus points for adjacent soil
				if (ground == Block.tilledField.blockID)
				{
					bonus = 1.0F;

					// bonus points for hydrated soil
					if (world.getBlockMetadata(i, z - 1, j) > 0)
					{
						bonus = 3.0F;
					}
				}

				// adjacent soil is only worth 25%
				if (i != x || j != y)
				{
					bonus /= 4.0F;
				}
				else if (bonemeal)
				{
					// for ourselves, we apply a bonus equivalent to
					// double-watering for being bonemealed
					bonus += 2.0F;
				}

				finalRate += bonus;
			}
		}

		// 50% penalty if surrounded on any two sides

		boolean adjX = (e == this.blockID || w == this.blockID);
		boolean adjY = (n == this.blockID || s == this.blockID);
		boolean adjD = (ne == this.blockID || nw == this.blockID
				|| sw == this.blockID || se == this.blockID);

		if (adjD || adjX && adjY)
		{
			finalRate /= 2.0F;
		}

		// TODO :: add modifier for fertilizer/bonemeal

		return finalRate;
	}

	public int getBlockTextureFromSideAndMetadata(int side, int meta)
	{
		meta = getGrowthLevel(meta);
		if (meta < 0 || meta > this.growthStages)
		{
			meta = this.growthStages;
		}

		return this.blockIndexInTexture + meta;
	}

	public abstract int getRenderType();

	public abstract ArrayList<ItemStack> getBlockDropped(World world, int x,
			int y, int z, int metadata, int fortune);

	public abstract int idDropped(int par1, Random par2Random, int par3);

	public abstract int quantityDropped(Random par1Random);

	@Override
	public Block setUnlocalizedName(String name)
	{
		String newname = "crop." + name;
		return super.setUnlocalizedName(newname);
	}

	// needs to be reworked

	/*@Override
	public boolean onUseBonemeal(World world, int blockID, int X, int Y, int Z) {
		final int meta = world.getBlockMetadata(X, Y, Z);
		if( isBonemealed(meta) ) {
			return false;
		} else {
			// apply the bonemeal bit to our meta
			world.setBlockMetadataWithNotify(X, Y, Z, meta | BIT_BONEMEAL);
			return true;
		}
	} */

}
