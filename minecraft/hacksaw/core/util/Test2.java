package hacksaw.core.util;

import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.src.forge.ICraftingHandler;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.IInventory;

public class Test2 {
	
	public static HashMap<Integer,Integer> containers = new HashMap<Integer,Integer>();
	public static HashSet craftDamage = new HashSet();

	public static void CrazyCraftingSetup()
    {
        ICraftingHandler icraftinghandler = new ICraftingHandler()
        {
            public void onTakenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
            {
                for (int i = 0; i < iinventory.getSizeInventory(); i++)
                {
                    ItemStack itemstack1 = iinventory.getStackInSlot(i);

                    if (itemstack1 == null || !craftDamage.contains(Integer.valueOf(itemstack1.itemID)))
                    {
                        continue;
                    }

                    itemstack1.stackSize++;
                    itemstack1.damageItem(1, entityplayer);

                    if (itemstack1.stackSize != 1)
                    {
                        continue;
                    }

                    Integer integer = containers.get(Integer.valueOf(itemstack1.itemID));

                    if (integer != null)
                    {
                        iinventory.setInventorySlotContents(i, new ItemStack(integer.intValue(), 2, 0));
                    }
                }
            }
        }
        ;
        MinecraftForge.registerCraftingHandler(icraftinghandler);
    }
	
	
	
}
