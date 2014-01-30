package hacksaw.core.blocks.crops;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.blocks.BlockBaseCrop;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCarrot extends BlockBaseCrop
{

    public BlockCarrot(int id)
    {
        super(id, 0, 4);
        this.setHardness(1.0F);
        this.setStepSound(soundWoodFootstep);
        this.setUnlocalizedName("carrot");
        this.setMinLight(9);
        this.setBaseGrowthRate(1.0F);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        // You must use shifted index as the Item ID is - 256 on the 'actual'
        // value
        return HacksawItems.carrot.item.itemID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 2;
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
        return HacksawBlocks.carrotCrop.renderId;
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        final int growth = this.getGrowthLevel(metadata);
        // drop 0-2 carrots
        int numCarrots = (growth * quantityDropped(world.rand)) / this.growthStages;
        if (numCarrots > 0)
        {
            drops.add(new ItemStack(HacksawItems.carrot.item, numCarrots));
        }

        for (int n = 0; n < 3 + fortune; n++)
        {
            // 50% chance to drop a seed per growth
            if (world.rand.nextInt(this.growthStages * 2) <= growth)
            {
                drops.add(new ItemStack(HacksawItems.carrotSeed.item));
            }
        }

        return drops;
    }
}
