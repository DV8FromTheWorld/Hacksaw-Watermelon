package hacksaw.core.util;

import hacksaw.core.BlockRemover;
import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawItems;
import hacksaw.core.MeatProvider;
import hacksaw.core.blocks.crops.BlockCarrot;
import hacksaw.core.blocks.crops.BlockLettuce;
import hacksaw.core.blocks.crops.BlockSuperMelon;
import hacksaw.core.items.food.ItemAppleGreen;
import hacksaw.core.items.food.ItemAppleGreenSliced;
import hacksaw.core.items.food.ItemAppleRedSliced;
import hacksaw.core.items.food.ItemCarrot;
import hacksaw.core.items.food.ItemCarrotSliced;
import hacksaw.core.items.food.ItemLambChopCooked;
import hacksaw.core.items.food.ItemLambChopRaw;
import hacksaw.core.items.food.ItemLettuce;
import hacksaw.core.items.food.ItemLettuceSliced;
import hacksaw.core.items.food.ItemOrange;
import hacksaw.core.items.food.ItemOrangeSliced;
import hacksaw.core.items.seeds.ItemCarrotSeed;
import hacksaw.core.items.seeds.ItemLettuceSeed;
import hacksaw.core.items.tools.ItemChefKnifeDull;
import hacksaw.core.items.tools.ItemChefKnifeSharp;
import hacksaw.core.items.tools.ItemKnifeSharpener;
import hacksaw.core.machines.GrillRecipes;
import hacksaw.core.util.HacksawLogger.LogLevel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import recipes.ChefKnifeRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Register
{

    public static void registerItemsAndBlocksAndRecipes()
    {
        registerBlocks();
        registerBlockNames();
        registerItems();
        registerItemNames();
        registerHandlers();
        addShapedRecipes();
        addShapelessRecipes();
        addGrillRecipes();
        addJuicerRecipes();
    }

    private static void registerBlocks()
    {
        //====================== Registers blocks ========================

        //---------Vegetation----------
        // if the block was removed
        if (BlockRemover.removeVanillaBlock(Block.melon))
        {
            // initialize the block
            HacksawBlocks.supermelon.block = new BlockSuperMelon(HacksawBlocks.supermelon.blockId);
            // log some success message
            HacksawLogger.log(LogLevel.DEBUG, "BlockSuperMelon loaded successfully.");
        }

        HacksawBlocks.carrotCrop.block = new BlockCarrot(HacksawBlocks.carrotCrop.blockId);
        HacksawBlocks.lettuceCrop.block = new BlockLettuce(HacksawBlocks.lettuceCrop.blockId);
        /**
         * PLACEHOLDERS
         * HacksawBlocks.grill.block = new
         * BlockGrill(HacksawBlocks.grill.blockId, TileEntityGrill.class,
         * Material.iron);
         * HacksawBlocks.grillElectric.block = new
         * BlockGrill(HacksawBlocks.grillElectric.blockId,
         * TileEntityGrillElectric.class, Material.iron);
         **/
        //========= Register Each Block ==============

        // for each Block within the enum (HacksawBlocks)
        for (HacksawBlocks blocks : HacksawBlocks.values())
        {
            // Check the block is initialized
            if (blocks.block != null)
            {
                // Register the block with ModLoader
                //TODO: Before updating to beyond 1.6.4, change this. 
                GameRegistry.registerBlock(blocks.block);
            }
        }
    }

    private static void registerBlockNames()
    {
        //==================== Registers the names for the blocks ======================

        // for each Block within the enum (HacksawBlocks)
        for (HacksawBlocks blocks : HacksawBlocks.values())
        {
            // Check that the block is initialized and the block name is set
            if (blocks.block != null && blocks.name != null)
            {
                // Register the name of the block with ModLoader
                LanguageRegistry.addName(blocks.block, blocks.name);
            }
        }
    }

    private static void registerItems()
    {
        //====================== Registers the Items ========================

        //---------Tools----------
        HacksawItems.chefKnifeSharp.item = new ItemChefKnifeSharp(HacksawItems.chefKnifeSharp.itemId);
        HacksawItems.chefKnifeDull.item = new ItemChefKnifeDull(HacksawItems.chefKnifeDull.itemId);
        HacksawItems.knifeSharpener.item = new ItemKnifeSharpener(HacksawItems.knifeSharpener.itemId);

        //---------Food-----------		
        HacksawItems.carrot.item = new ItemCarrot(HacksawItems.carrot.itemId, 2, 0.3F, false);
        HacksawItems.carrotSliced.item = new ItemCarrotSliced(HacksawItems.carrotSliced.itemId, 1, 0.15F, false);
        HacksawItems.lettuce.item = new ItemLettuce(HacksawItems.lettuce.itemId, 2, 0.3F, false);
        HacksawItems.lettuceSliced.item = new ItemLettuceSliced(HacksawItems.lettuceSliced.itemId, 1, 0.15F, false);
        HacksawItems.lambChopRaw.item = new ItemLambChopRaw(HacksawItems.lambChopRaw.itemId, 3, 0.3F, false);
        HacksawItems.lambChopCooked.item = new ItemLambChopCooked(HacksawItems.lambChopCooked.itemId, 7, 0.7F, false);
        HacksawItems.orange.item = new ItemOrange(HacksawItems.orange.itemId, 4, 0.3F, false);
        HacksawItems.orangeSliced.item = new ItemOrangeSliced(HacksawItems.orangeSliced.itemId, 2, 0.15F, false);
        HacksawItems.appleRedSliced.item = new ItemAppleRedSliced(HacksawItems.appleRedSliced.itemId, 2, 0.15F, false);
        HacksawItems.appleGreen.item = new ItemAppleGreen(HacksawItems.appleGreen.itemId, 4, 0.3F, false);
        HacksawItems.appleGreenSliced.item = new ItemAppleGreenSliced(HacksawItems.appleGreenSliced.itemId, 2, 0.15F, false);

        //---------Seeds----------
        HacksawItems.carrotSeed.item = new ItemCarrotSeed(HacksawItems.carrotSeed.itemId, HacksawBlocks.carrotCrop.blockId);
        HacksawItems.lettuceSeed.item = new ItemLettuceSeed(HacksawItems.lettuceSeed.itemId, HacksawBlocks.lettuceCrop.blockId);
        //HacksawItems.appleSeed.item = new ItemAppleSeed(HacksawItems.appleSeed.itemId, HacksawBlocks.appleSappling.blockId);
    }

    private static void registerItemNames()
    {
        //======================= Registers the names for the items =======================

        // for each Item within the enum (HacksawItems)
        for (HacksawItems items : HacksawItems.values())
        {
            // Check that the item is initialized and the item name is set
            if (items.item != null & items.name != null)
            {
                // Register the name of the item with ModLoader
                LanguageRegistry.addName(items.item, items.name);
            }
        }
    }

    private static void addShapedRecipes()
    {
        //==================== Registers the shaped-recipes ====================

        //recipe for creating the Chef knife.  Contains full durability, so it is the "Sharp Chef Knife"
        GameRegistry.addRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item, 1), new Object[] { "  Y", " XY", "XY ", Character.valueOf('X'),
                Item.stick, Character.valueOf('Y'), Item.ingotIron });

        //recipe for creating a Knife Sharpener
        GameRegistry.addRecipe(new ItemStack(HacksawItems.knifeSharpener.item, 1), new Object[] { "X X", "YXY", "ZZZ", Character.valueOf('X'),
                Item.flint, Character.valueOf('Y'), Block.cobblestone, Character.valueOf('Z'), Block.planks });
    }

    private static void addShapelessRecipes()
    {
        //=================== Registers the shapeless-recipes ====================

        //recipe for using the Chef knife to cut melon blocks to get melon slices
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(Item.melon, 4), new Object[] { HacksawBlocks.supermelon.block,
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1) //Note: a new itemstack is made here because you want to be able to use the item no matter what the damage value
                }));

        //recipe for "sharpening" the Dull Chef knife
        GameRegistry.addShapelessRecipe(new ItemStack(HacksawItems.chefKnifeSharp.item), new Object[] { HacksawItems.chefKnifeDull.item,
                HacksawItems.knifeSharpener.item });

        //carrot seeds come from carrots
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.carrotSeed.item), new Object[] { new ItemStack(
                HacksawItems.carrot.item, 1, -1) }));

        //lettuce seeds come from lettuce
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.lettuceSeed.item), new Object[] { new ItemStack(
                HacksawItems.lettuce.item, 1, -1) }));

        //recipe for sliced carrots
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.carrotSliced.item, 2), new Object[] {
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1), HacksawItems.carrot.item }));

        //recipe for sliced lettuce
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.lettuceSliced.item, 4), new Object[] {
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1), HacksawItems.lettuce.item }));

        //recipe for sliced orange
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.orangeSliced.item, 2), new Object[] {
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1), HacksawItems.orange.item }));

        //recipe for sliced apple
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.appleRedSliced.item, 2), new Object[] {
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1), Item.appleRed }));

        //recipe for the sliced green apple
        GameRegistry.addRecipe(new ChefKnifeRecipe(new ItemStack(HacksawItems.appleGreenSliced.item, 2), new Object[] {
                new ItemStack(HacksawItems.chefKnifeSharp.item, 1, -1), HacksawItems.appleGreen.item }));
    }

    private static void registerHandlers()
    {
        //================= Registers Forge Handlers =========================
        MinecraftForge.EVENT_BUS.register(new MeatProvider());

    }

    private static void addGrillRecipes()
    {
        //================== Registers the cooking recipes for the Grill ===================

        GrillRecipes.addToGrillToCook(HacksawItems.lambChopRaw.item.itemID, new ItemStack(HacksawItems.lambChopCooked.item), 25);
    }

    private static void addJuicerRecipes()
    {
        //================== Registers the juicing recipes for the Juicer ====================

    }
}
