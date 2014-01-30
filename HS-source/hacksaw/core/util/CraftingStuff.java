package hacksaw.core.util;

import hacksaw.core.HacksawItems;

import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingStuff
{

    public static HashMap<Integer, Integer> containers = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> damage = new HashMap<Integer, Integer>();
    public static HashSet<Integer> craftDamage = new HashSet<Integer>();

    public static void init()
    {
        AddItemsForCrazyCraftingSetup();
        CrazyCraftingSetup();
    }

    public static void CrazyCraftingSetup()
    {
        ICraftingHandler ich = new ICraftingHandler() {
            @Override
            public void onCrafting(EntityPlayer playerCrafting, ItemStack itemstack, IInventory craftingInventory)
            {
                //the for loop loops through all the slots in the inventory
                for (int totalInventorySize = 0; totalInventorySize < craftingInventory.getSizeInventory(); totalInventorySize++)
                {

                    ItemStack itemInSlot = craftingInventory.getStackInSlot(totalInventorySize);

                    //the first if checks that you actually have an item in that slot, and that it's one of yours that can be damaged
                    if (itemInSlot == null || !craftDamage.contains(Integer.valueOf(itemInSlot.itemID)))
                    {

                        continue;
                    }

                    //Increases the stack size (because crafting decrease the stack size)
                    itemInSlot.stackSize++;

                    //Damages the item, this could break the item if it only had a durability of 1 remaining
                    itemInSlot.damageItem(1, playerCrafting);

                    //Checks to see if there is still an item.  If it broke because of the previous method, then it will continue, if not, then we're done.
                    if (itemInSlot.stackSize != 1)
                    {
                        continue;
                    }

                    /*
                     * replacementItemId: Gets the ID of the current item
                     * (itemInSlot.itemID) and matches that against the
                     * "containers" hashmap.
                     * if it finds a entry that corresponds with the ID
                     * (provided by the containers.put() method), it sets
                     * "replacementItemId" to that entry for later use in the
                     * craftingInventory.setInventorySlotContents() method below
                     * 
                     * damageValue: Gets the ID of the current item
                     * (itemInSlot.itemID) and matches that against the "damage"
                     * hashmap.
                     * if it finds and entry that corresponds with the ID
                     * (provided by the damage.put() method), it sets the
                     * "damageValue" to that entry for later use in the
                     * craftingInventory.setInventorySlotContents() method below
                     */
                    Integer replacementItemId = containers.get(Integer.valueOf(itemInSlot.itemID));
                    Integer damageValue = damage.get(Integer.valueOf(itemInSlot.itemID));

                    //checks if the variable "replacementItemId" isn't null(otherwise it would crash on items like the "Knife Sharpener" because it doesnt have a "replacement" item in the "containers" hashmap 
                    if (replacementItemId != null)
                    {
                        //checks if there is a damageValue specified, if not, it uses the default "0" as the damage value (hence the if else statment)
                        if (damageValue != null)
                        {
                            /*
                             * Sets the Item ID based on the variable
                             * "replacementItemId"
                             * Sets the damage value based on the variable
                             * "damageValue"
                             */
                            craftingInventory.setInventorySlotContents(totalInventorySize,
                                    new ItemStack(replacementItemId.intValue(), 2, damageValue.intValue()));

                        }
                        else
                        {
                            /*
                             * Sets the Item ID based on the variable
                             * "replacementItemId"
                             * Doesnt not set a specific Damage value because
                             * one was not specified, instead it sets it to a
                             * default of 0
                             */
                            craftingInventory.setInventorySlotContents(totalInventorySize, new ItemStack(replacementItemId.intValue(), 2, 0));
                        }

                    }
                }
            }

            @Override
            public void onSmelting(EntityPlayer player, ItemStack item)
            {
            }

        };
        GameRegistry.registerCraftingHandler(ich);
    }

    public static void AddItemsForCrazyCraftingSetup()
    {

        /*
         * @para1 int: Item that can be damaged in crafting recipe
         * Note: Note: you need to use .item.itemID instead of .itemId because
         * MC wont understand the ID correctly.
         */
        craftDamage.add(HacksawItems.chefKnifeSharp.item.itemID);
        craftDamage.add(HacksawItems.knifeSharpener.item.itemID);

        /*
         * @para1 int: Item that has durability, EX: Ic2 charged battery.
         * 
         * @para2 int: Item that does not have durability, EX: ic2 uncharged
         * battery
         * 
         * Note: Item from @para1 will be replaced by Item from @para2 if it
         * breaks in recipe
         * Note: you need to use .item.itemID instead of .itemId because MC wont
         * understand the ID correctly.
         */
        containers.put(HacksawItems.chefKnifeSharp.item.itemID, HacksawItems.chefKnifeDull.item.itemID);
        //containers.put(HacksawItems.appleRedSliced.item.itemID, HacksawItems.appleSeed.item.itemID);
        //containers.put(HacksawItems.appleGreenSliced.item.itemID, HacksawItems.appleSeed.item.itemID);

        /*
         * @para1 int: Item that will break
         * 
         * @para2 int: Damage value that will be set on the item that replaces
         * the broken item
         * 
         * Note: Item from @para1 will be replaced by Item from @para2 if it
         * breaks in recipe
         */
        damage.put(HacksawItems.chefKnifeSharp.item.itemID, 99);
    }

}
