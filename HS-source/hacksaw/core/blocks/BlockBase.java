package hacksaw.core.blocks;

import hacksaw.core.items.ItemBlockBase;
import hacksaw.core.tileentities.TileEntityBase;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class BlockBase extends BlockContainer
{

    protected Class[] tileEntityMap;

    /**
     * Abstract Class BlockBaseMachine
     * 
     * @param blockId
     *            the ID of the Block
     */
    protected BlockBase(int blockId, Material material, int maxTiles)
    {
        super(blockId, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.tileEntityMap = new Class[maxTiles];
    }

    /**
     * This retrieves the Tile Entity class from our registered data
     * 
     * @param metadata
     * @return
     */
    public Class getTileMapData(int metadata)
    {
        if (metadata < this.tileEntityMap.length)
        {
            return this.tileEntityMap[metadata];
        }
        else
        {
            return null;
        }
    }

    /**
     * Here we register a sub Item and Tile Entity for our block
     * 
     * @param metadata
     * @param tileEntityClass
     * @param unlocalizedName
     */
    public void addMapping(int metadata, Class<? extends TileEntity> tileEntityClass, String unlocalizedName)
    {
        this.tileEntityMap[metadata] = tileEntityClass;
        GameRegistry.registerTileEntity(tileEntityClass, unlocalizedName);
        this.setItemName(metadata, unlocalizedName);
    }

    /**
     * This allows us to add an unlocalized name for the sub item block
     * 
     * @param metadata
     * @param name
     */
    public void setItemName(int metadata, String name)
    {
        Item item = Item.itemsList[this.blockID];
        if (item != null)
        {
            ((ItemBlockBase) item).setMetaName(metadata, (new StringBuilder()).append("tile.").append(name).toString());
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        return this.doBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
    }

    /**
     * Forces Child classes to implement this method
     */
    protected abstract boolean doBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ);

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        try
        {
            // Will return an instance from our tile map if there is no reference we SHOULD crash
            return (TileEntity) this.getTileMapData(metadata).newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return this.createTileEntity(world, 0);
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        this.registerBlockIcons(iconRegister);
    }

    /**
     * This forces child classes to implement this method in order to register
     * block icons
     */
    protected abstract void registerBlockIcons(IconRegister iconRegister);

    @Override
    public Icon getIcon(int side, int metadata)
    {
        return this.getIconFromSideAndMetadata(side, metadata);
    }

    /**
     * This forces child classes to implement this method in order to retrieve
     * an icon using the side and metadata
     */
    protected abstract Icon getIconFromSideAndMetadata(int side, int metadata);

    @Override
    public Icon getBlockTexture(IBlockAccess iblockaccess, int x, int y, int z, int side)
    {
        return this.getBlockTextureAt(iblockaccess, x, y, z, side);
    }

    /**
     * This forces child classes to implement this method to return a custom
     * registered icon, we can use this to return rotated side icons
     */
    protected abstract Icon getBlockTextureAt(IBlockAccess iblockaccess, int x, int y, int z, int side);

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack)
    {
        this.onBlockPlacedByLiving(world, x, y, z, entityplayer, itemstack);
    }

    /**
     * This is the default onBlockPlaced implementation, we can override this,
     * but should always use the super in order to handle the default placement
     * information e.g. rotation
     */
    protected void onBlockPlacedByLiving(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        TileEntityBase tileentitybase = (TileEntityBase) getTileEntity(world, x, y, z, this.getTileMapData(metadata));
        if (tileentitybase != null)
        {
            tileentitybase.onBlockPlacedBy(itemstack, entityplayer);
        }
    }

    /**
     * A static helper method to assist retrieval and comparisson of Tile Entity
     * classes
     */
    public static Object getTileEntity(IBlockAccess world, int x, int y, int z, Class tileEntityClass)
    {
        if (tileEntityClass == null)
        {
            return null;
        }
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        if (!tileEntityClass.isInstance(tileentity))
        {
            return null;
        }
        else
        {
            return tileentity;
        }
    }
}
