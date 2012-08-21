package hacksaw.core.blocks;

import hacksaw.core.HacksawItems;

import java.util.Random;

import net.minecraft.src.BlockMelon;

public class BlockCarrot extends BlockMelon {

	public BlockCarrot(int par1) {
		super(par1);
		this.setHardness(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setBlockName("carrot");
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3) {
        return HacksawItems.carrot.itemId;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random) {
    	// quantity dropped is eventually determined by age of "plant" 0-4 carrots i think
        return 2;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return 1;
    }
}
