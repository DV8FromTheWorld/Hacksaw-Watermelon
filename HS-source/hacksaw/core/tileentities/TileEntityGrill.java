package hacksaw.core.tileentities;

import hacksaw.core.HacksawGuiIds;
import net.minecraft.item.ItemStack;

public class TileEntityGrill extends TileEntityBase
{

    /**
     * Creates a TileEntity with 19 inventory slots.
     * 9 are the input for cooking food. (0-8)
     * 9 are the output for cooking food. (9-17)
     * 1 is the input for fuel. (18)
     */
    public TileEntityGrill()
    {
        super(19);
    }   

    @Override
    public String getInvName()
    {
        return "hacksaw.tileentitygrill";
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack)
    {
        //Prevents placing items in output slots.
        if (slotIndex >= 8  && slotIndex <= 17)
        {
            return false; 
        }
        return true;
    }

}
