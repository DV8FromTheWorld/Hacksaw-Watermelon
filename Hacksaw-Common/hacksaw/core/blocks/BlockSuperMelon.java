package hacksaw.core.blocks;

import java.util.Random;

import net.minecraft.src.BlockMelon;

public class BlockSuperMelon extends BlockMelon {

	public BlockSuperMelon(int par1) {
		super(par1);
		this.setHardness(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setBlockName("melon");
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random) {
        return 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return 1;
    }
}
