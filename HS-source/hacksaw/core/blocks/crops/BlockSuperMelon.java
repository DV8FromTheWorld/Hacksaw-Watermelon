package hacksaw.core.blocks.crops;

import hacksaw.core.HacksawItems;

import java.util.Random;

import net.minecraft.block.BlockMelon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockSuperMelon extends BlockMelon
{

    public BlockSuperMelon(int id)
    {
        super(id);
        this.setHardness(1.0F);
        this.setStepSound(soundWoodFootstep);
        this.setUnlocalizedName("melon");
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int subtype)
    {
        // Check the player is holding an item
        if (entityplayer.getCurrentEquippedItem() != null)
        {
            // Check if that item is the Chef's Sharp Knife
            if (entityplayer.getCurrentEquippedItem().itemID == HacksawItems.chefKnifeSharp.item.itemID)
            {
                // create a new Random generator
                Random drop = new Random();
                // Get a random drop chance between 3 and 8 (slices)
                int drops = drop.nextInt(8 - 3 + 1) + 3;
                // Drop as stack of (drops size) Item.melon
                this.dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.melon, drops));
                // Damage the Chef's Sharp Knife for 1 point
                entityplayer.getCurrentEquippedItem().damageItem(1, entityplayer);
            }
        }
        else
        {
            // Call the super harvestBlock method
            super.harvestBlock(world, entityplayer, x, y, z, subtype);
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
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
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 1;
    }
}
