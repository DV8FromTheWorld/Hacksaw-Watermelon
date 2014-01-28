package hacksaw.core.machines.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGrill extends TileEntity implements IInventory,
		ISidedInventory
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
		return "container.grill";
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

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.ISidedInventory#getAccessibleSlotsFromSide(int)
	 */
	@Override
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.ISidedInventory#canInsertItem(int, net.minecraft.item.ItemStack, int)
	 */
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.ISidedInventory#canExtractItem(int, net.minecraft.item.ItemStack, int)
	 */
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.IInventory#isInvNameLocalized()
	 */
	@Override
	public boolean isInvNameLocalized()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.IInventory#isItemValidForSlot(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
