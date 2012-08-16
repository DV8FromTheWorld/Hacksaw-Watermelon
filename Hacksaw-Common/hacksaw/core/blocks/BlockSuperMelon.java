package hacksaw.core.blocks;

import hacksaw.core.BlockRemover;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockMelon;
import net.minecraft.src.Item;

public class BlockSuperMelon extends BlockMelon {

	public BlockSuperMelon(int par1) {
		super(par1);
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 1;
    }
}
