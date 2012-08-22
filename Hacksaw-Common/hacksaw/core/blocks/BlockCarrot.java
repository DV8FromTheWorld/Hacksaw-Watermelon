package hacksaw.core.blocks;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCarrot extends BlockBaseCrop {

	public BlockCarrot(int id) {
		super(id, 0, 4);
		this.setHardness(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setBlockName("carrot");
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int z, int y, Random rng) {
		super.updateTick(world, x, z, y, rng);

		System.out.println("carrot " + x + "/" + y + " tick...");

		// only grow if it's light
		if (world.getBlockLightValue(x, z + 1, y) >= 9) {
			int growthLevel = world.getBlockMetadata(x, z, y);

			if (growthLevel < this.growthStages) {
				float growthRate = 100.0f;// this.getGrowthRate(world, x, z, y);

				if (rng.nextInt((int) (25.0F / growthRate) + 1) == 0) {
					System.out.println("growing carrot to " + growthLevel);
					++growthLevel;
					world.setBlockMetadataWithNotify(x, z, y, growthLevel);
				}
			} else {
				System.out.println("carrot is already " + growthLevel);
			}
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		// You must use shifted index as the Item ID is - 256 on the 'actual'
		// value
		return HacksawItems.carrot.item.shiftedIndex;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		// quantity dropped is eventually determined by age of "plant" 0-4
		// carrots i think
		return 2;
	}

	/**
	 * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
	 * (inclusive).
	 */
	@Override
	public int quantityDroppedWithBonus(int i, Random random) {
		int bonus = this.quantityDropped(random) + random.nextInt(1 + i);

		if (bonus > 4) {
			bonus = 4;
		}
		return bonus;
	}

	@Override
	public int getRenderType() {
		return HacksawBlocks.carrot.renderId;
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y,
			int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (metadata == this.growthStages) {
			ret.add(new ItemStack(HacksawItems.carrot.item));
		}

		for (int n = 0; n < 3 + fortune; n++) {
			if (world.rand.nextInt(15) <= metadata) {
				ret.add(new ItemStack(HacksawItems.carrotSeed.item));
			}
		}

		return ret;
	}
}
