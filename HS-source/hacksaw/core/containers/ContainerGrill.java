package hacksaw.core.containers;

import hacksaw.core.tileentities.TileEntityGrill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerGrill extends ContainerBase
{
    private static final Coord INV_COORD = new Coord(14, 92);
    private static final Coord GRILL_LEFT = new Coord(9, 8);
    private static final Coord GRILL_RIGHT = new Coord(121, 10);
    private static final Coord GRILL_FUEL = new Coord(93, 59);

    protected TileEntityGrill tileEntity;

    /**
     * Creates a new Container for the a Grill TileEntity.
     * Used to control the normal Grill's GUI.
     * 
     * @param inventoryPlayer
     *            The inventory of the player currently using the tile entity.
     * @param te
     *            The tile entity being used by the player.
     */
    public ContainerGrill(InventoryPlayer inventoryPlayer, TileEntityGrill te)
    {
        this.tileEntity = te;
        this.bindContainerSlots();
        super.bindPlayerInventory(inventoryPlayer, INV_COORD, true);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return tileEntity.isUseableByPlayer(player);
    }

    /**
     * Binds the specific slots of the Grill GUI to their correct places.
     * Slots: 0-8 are input, 9-17 are output, and 18 is fuel. (total 19).
     */
    @Override
    public void bindContainerSlots()
    {
        final int LEFT_SPACING = 7;
        final int RIGHT_SPACING_X = 3;
        final int RIGHT_SPACING_Y = 5;
        int slot = 0;

        //Slots on left side (input slots) (slots: 0-8)
        for (int rows = 0; rows < 3; rows++)
        {
            for (int columns = 0; columns < 3; columns++)
            {
                addSlotToContainer(new Slot(tileEntity, slot, GRILL_LEFT.X + (columns * SLOT_SIZE) + (columns * LEFT_SPACING), GRILL_LEFT.Y
                        + (rows * SLOT_SIZE) + (rows * LEFT_SPACING)));
                slot++;
            }
        }

        //Slots on the right side (output slots) (slots: 9-17)
        for (int rows = 0; rows < 3; rows++)
        {
            for (int columns = 0; columns < 3; columns++)
            {
                addSlotToContainer(new Slot(tileEntity, slot, GRILL_RIGHT.X + (columns * SLOT_SIZE) + (columns * RIGHT_SPACING_X), GRILL_RIGHT.Y
                        + (rows * SLOT_SIZE) + (rows * RIGHT_SPACING_Y)));
                slot++;
            }
        }

        //Slot for the fuel (slot: 18)
        addSlotToContainer(new Slot(tileEntity, slot, GRILL_FUEL.X, GRILL_FUEL.Y));
    }
}
