package hacksaw.core.blocks;

import hacksaw.core.HacksawItems;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockCarrot extends Block {

	public BlockCarrot(int id) {
		super(id, Material.pumpkin);
		this.setHardness(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setBlockName("carrot");
	}

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3) {
    	// You must use shifted index as the Item ID is - 256 on the 'actual' value
        return HacksawItems.carrot.item.shiftedIndex;
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
    public int quantityDroppedWithBonus(int i, Random random) {
        int bonus = this.quantityDropped(random) + random.nextInt(1 + i);

        if (bonus > 4) {
        	bonus = 4;
        }
        return bonus;
    }
}
