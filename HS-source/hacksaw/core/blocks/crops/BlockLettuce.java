package hacksaw.core.blocks.crops;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.blocks.BlockBaseCrop;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockLettuce extends BlockBaseCrop
{

    public BlockLettuce(int id)
    {
        super(id, 4, 4);
        this.setHardness(1.0F);
        this.setStepSound(soundWoodFootstep);
        this.setUnlocalizedName("lettuce");
        this.setMinLight(9);
        this.setBaseGrowthRate(1.0F);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return HacksawItems.lettuce.item.itemID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
     * (inclusive).
     */
    @Override
    public int quantityDroppedWithBonus(int i, Random random)
    {
        int bonus = this.quantityDropped(random) + random.nextInt(1 + i);

        if (bonus > 4)
        {
            bonus = 4;
        }
        return bonus;
    }

    @Override
    public int getRenderType()
    {
        return HacksawBlocks.lettuceCrop.renderId;
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        final int growth = this.getGrowthLevel(metadata);
        if (growth == this.growthStages)
        {
            drops.add(new ItemStack(HacksawItems.lettuce.item, 1));
        }

        for (int n = 0; n < 3 + fortune; n++)
        {
            if (world.rand.nextInt(this.growthStages) <= growth)
            {
                drops.add(new ItemStack(HacksawItems.lettuceSeed.item));
            }
        }

        return drops;
    }
}
