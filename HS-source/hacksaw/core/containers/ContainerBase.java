package hacksaw.core.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class ContainerBase extends Container
{
    public final int INV_LENGTH = 9;
    public final int INV_HEIGHT = 3;
    public static final int SLOT_SIZE = 18;
    public final int HOT_BAR_GAP = 58;

    private final IInventory inventory;

    /**
     * Super constructor for containers without a player inventory
     * 
     * @param iinventory
     *            the inventory we want to bind
     */
    protected ContainerBase(IInventory iinventory)
    {
        this.inventory = iinventory;
        this.bindContainerSlots();
    }

    /**
     * Super constructor with player inventory and a choice to bind the hotbar.
     * 
     * @param playerInventory
     *            the Inventory of the player.
     * @param iinventory
     *            the inventory we want to bind.
     * @param playerInventoryCoords
     *            the coordinates where we would like to bind the player
     *            inventory.
     * @param shouldBindHotbar
     *            if we should bind the player's hotbar.
     */
    protected ContainerBase(InventoryPlayer playerInventory, IInventory iinventory, Coord playerInventoryCoords, boolean shouldBindHotbar)
    {
        this.inventory = iinventory;
        this.bindContainerSlots();
        this.bindPlayerInventory(playerInventory, playerInventoryCoords, shouldBindHotbar);
    }

    /**
     * The inventory of the Tile Entity.
     * 
     * @return the inventory
     */
    public IInventory getInventoryData()
    {
        return inventory;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.getInventoryData().isUseableByPlayer(player);
    }

    /**
     * Binds the player's inventory slots based on the provided coordinates.
     * 
     * @param inventoryPlayer
     *            The inventory of the player.
     * @param xCoord
     *            The xCoord of the top-left slot of the Inventory.
     * @param yCoord
     *            The yCoord of the top-left slot of the Inventory.
     * @param bindHotBar
     *            If false, will not bind the Hot Bar.
     */
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer, Coord invCoord, boolean bindHotBar)
    {
        for (int rows = 0; rows < INV_HEIGHT; rows++)
        {
            for (int columns = 0; columns < INV_LENGTH; columns++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, (columns + (rows * INV_LENGTH)) + 9, invCoord.X + (columns * SLOT_SIZE), invCoord.Y
                        + (rows * SLOT_SIZE)));
            }
        }
        if (bindHotBar)
        {
            bindPlayerHotBar(inventoryPlayer, new Coord(invCoord.X, invCoord.Y + HOT_BAR_GAP));
        }
    }

    /**
     * Binds the player's hot bar slots based on the provided coordinates.
     * Allows for separate binding in case the entire inventory is not
     * present in the GUI.
     * 
     * @param inventoryPlayer
     *            The inventory of the player.
     * @param xCoord
     *            The xCoord of the first slot of the Hot Bar.
     * @param yCoord
     *            The yCoord of the first slot of the Hot Bar.
     */
    protected void bindPlayerHotBar(InventoryPlayer inventoryPlayer, Coord coord)
    {
        for (int slot = 0; slot < 9; slot++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, slot, coord.X + (slot * SLOT_SIZE), coord.Y));
        }
    }

    /**
     * Controls the transferring of items.
     * Provides shift-clicking ability.
     * 
     * @param player
     *            The player using the GUI.
     * @param slot
     *            The slot that the player is interacting with.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        // null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack())
        {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            // merges the item into player inventory since its in the tileEntity
            if (slot < 9)
            {
                if (!this.mergeItemStack(stackInSlot, 0, 35, true))
                {
                    return null;
                }
            }
            // places it into the tileEntity is possible since its in the player
            // inventory
            else if (!this.mergeItemStack(stackInSlot, 0, 9, false))
            {
                return null;
            }

            if (stackInSlot.stackSize == 0)
            {
                slotObject.putStack(null);
            }
            else
            {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize)
            {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }

    /**
     * Binds the slots specific to the container's GUI.
     */
    public abstract void bindContainerSlots();
}
