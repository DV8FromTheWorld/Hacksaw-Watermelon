package hacksaw.core.machines.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityGrillElectric extends TileEntityGrill
{

    @Override
    public int getSizeInventory()
    {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int var1)
    {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2)
    {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2)
    {

    }

    @Override
    public String getInvName()
    {
        return "container.grill.electric";
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 4;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return false;
    }

    @Override
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {
    }

}
