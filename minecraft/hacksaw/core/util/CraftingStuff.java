package hacksaw.core.util;

import hacksaw.core.HacksawItems;

import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.src.forge.ICraftingHandler;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.IInventory;

public class CraftingStuff {
	
	public static HashMap<Integer,Integer> containers = new HashMap<Integer,Integer>();
	public static HashSet<Integer> craftDamage = new HashSet<Integer>();

	
	public static void init(){
		AddItemsForCrazyCraftingSetup();
		CrazyCraftingSetup();
	}
	
	public static void CrazyCraftingSetup()
    {
        ICraftingHandler icraftinghandler = new ICraftingHandler()
        {
            public void onTakenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
            {
            	//the for loop loops through all the slots in the inventory
                for (int i = 0; i < iinventory.getSizeInventory(); i++)
                {

                    ItemStack itemstack1 = iinventory.getStackInSlot(i);
                    
                    //the first if checks that you actually have an item in that slot, and that it's one of yours that can be damaged
                    if (itemstack1 == null || !craftDamage.contains(Integer.valueOf(itemstack1.itemID)))
                    {
                    	
                        continue;
                    }
                    
                    //Increases the stack size (because crafting decrease the stack size)
                    itemstack1.stackSize++;
                    
                    //Damages the item, this could break the item if it only had a durability of 1 remaining
                    itemstack1.damageItem(1, entityplayer);

                    //Checks to see if there is still an item.  If it broke because of the previous method, then it will continue, if not, then we're done.
                    if (itemstack1.stackSize != 1)
                    {
                        continue;
                    }
                    //gets the item we added as a "replacement" if it should break
                    Integer integer = containers.get(Integer.valueOf(itemstack1.itemID));
                    
                    //makes sure that it isnt null
                    if (integer != null)
                    {	
                    	//sets the same slot that held the item that broke to contain the "replacement" item.  Mostlikely the "empty" or used-up version.
                        iinventory.setInventorySlotContents(i, new ItemStack(integer.intValue(), 2, 0));
                    }
                }
            }
        }
        ;
        MinecraftForge.registerCraftingHandler(icraftinghandler);
    }
	
	public static void AddItemsForCrazyCraftingSetup(){
		
			/*
			 * @para1 int: Item that can be damaged in crafting recipe
			 * Note: Note: you need to use .item.shiftedIndex instead of .itemId because MC wont understand the ID correctly.
			 */		
		craftDamage.add(HacksawItems.sharpChefKnife.item.shiftedIndex);
					
			/*
			 * @para1 int: Item that has durability,  EX: Ic2 charged battery.
			 * @para2 int: Item that does not have durability, EX: ic2 uncharged battery
			 * 
			 * Note:  Item from @para1 will be replaced by Item from @para2 if it breaks in recipe
			 * Note: you need to use .item.shiftedIndex instead of .itemId because MC wont understand the ID correctly.
			 */
		containers.put(HacksawItems.sharpChefKnife.item.shiftedIndex, HacksawItems.dullChefKnife.item.shiftedIndex);
	}
	
}
