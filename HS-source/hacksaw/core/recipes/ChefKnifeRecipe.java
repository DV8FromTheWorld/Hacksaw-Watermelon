package hacksaw.core.recipes;

import hacksaw.core.HacksawItems;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

/**
 * Provides shapeless crafting for the ChefKnife.
 * Required because Minecraft doesn't support damaged items correctly.
 * 
 * @author DV8FromTheWorld (Austin Keener)
 */
public class ChefKnifeRecipe implements IRecipe
{

    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;

    /** Is a List of ItemStack that composes the recipe. */
    public final ArrayList<ItemStack> recipeItems;

    /**
     * Constructor to create a recipe that doesn't ignores the Chef Knife's
     * damage value.
     * 
     * @param itemStackOutput
     *            The output of the recipe.
     * @param inputRecipe
     *            The recipe needed to create the output ItemStack.
     */
    public ChefKnifeRecipe(ItemStack itemStackOutput, Object... inputRecipe)
    {
        this.recipeOutput = itemStackOutput;
        this.recipeItems = recipeAsArrayList(inputRecipe);
    }

    /**
     * Returns the output of this recipe as an ItemStack.
     * 
     * @return The recipe output.
     */
    @Override
    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory.
     * Different from vanilla one in that it doesn't compare damage value of the
     * chef knife.
     * 
     * @param inventoryCrafting
     *            The inventory of the crafting table being used by the player.
     * @param world
     *            The current world that player is in.
     */
    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world)
    {
        ArrayList<ItemStack> recipeList = new ArrayList<ItemStack>(this.recipeItems);

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemInCraftingTable = inventoryCrafting.getStackInRowAndColumn(j, i);

                if (itemInCraftingTable != null)
                {
                    boolean flag = false;
                    Iterator<ItemStack> itemInRecipe = recipeList.iterator();

                    while (itemInRecipe.hasNext())
                    {
                        ItemStack itemstack1 = itemInRecipe.next();

                        if (itemInCraftingTable.itemID == itemstack1.itemID)
                        {
                            if (itemInCraftingTable.itemID == HacksawItems.chefKnifeSharp.item.itemID)
                            {
                                flag = true;
                                recipeList.remove(itemstack1);
                                break;
                            }
                            else if (itemstack1.getItemDamage() == 32767 || itemInCraftingTable.getItemDamage() == itemstack1.getItemDamage())
                            {
                                flag = true;
                                recipeList.remove(itemstack1);
                                break;
                            }

                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return recipeList.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     * 
     * @param inventoryCrafting
     *            The inventory of the crafting table being used by the player.
     */
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     * 
     * @return returns the total size of the recipe (max 9).
     */
    @Override
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }

    /**
     * Helper method that takes apart the recipe and puts it into a list.
     * Essentially identical to the implementation of
     * CraftingManager.addShapelessRecipe(ItemStack, Object...).
     * 
     * @param recipe
     *            The recipe, as an Object[], to be changed to an arrayList.
     * @return
     */
    private ArrayList<ItemStack> recipeAsArrayList(Object[] recipe)
    {
        ArrayList<ItemStack> recipeList = new ArrayList<ItemStack>();
        int i = recipe.length;

        for (int j = 0; j < i; ++j)
        {
            Object partOfRecipe = recipe[j];

            if (partOfRecipe instanceof ItemStack)
            {
                recipeList.add(((ItemStack) partOfRecipe).copy());
            }
            else if (partOfRecipe instanceof Item)
            {
                recipeList.add(new ItemStack((Item) partOfRecipe));
            }
            else
            {
                if (!(partOfRecipe instanceof Block))
                {
                    throw new RuntimeException("Invalid ChefKnifeRecipe!  Attemped to add: " + partOfRecipe + " to recipe");
                }

                recipeList.add(new ItemStack((Block) partOfRecipe));
            }
        }
        return recipeList;
    }
}
