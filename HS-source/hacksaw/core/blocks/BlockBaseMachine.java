package hacksaw.core.blocks;

import hacksaw.core.mod_Hacksaw;
import hacksaw.core.machines.tileentities.TileEntityBase;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockBaseMachine extends BlockContainer
{

    /**
     * machineClass is the TileEntity class associated with the Block Instance
     */
    private Class<? extends TileEntityBase> machineClass;
    private int guiId;

    /**
     * Abstract Class BlockBaseMachine
     * 
     * @param blockId
     *            the ID of the Block
     * @param machineClass
     *            the TileEntity class associated with the Block instance
     * @param guiId
     *            the GUI id of the block / tile entity.
     */
    protected BlockBaseMachine(int blockId, Class<? extends TileEntityBase> machineClass, int guiId)
    {
        super(blockId, Material.iron);
        this.machineClass = machineClass;
        this.guiId = guiId;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float hitX, float hitY, float hitZ) 
    {
        if (world.isRemote)
        {
            return true;
        }
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) 
        {
                return false;
        }
        if (!tileEntity.getClass().isAssignableFrom(machineClass))
        {
            return false;
        }
        player.openGui(mod_Hacksaw.INSTANCE, guiId, world, x, y, z);
        return true;
    }

    /**
     * This return the TileEntity based on the class set in the constructor
     */
    @Override
    public TileEntity createNewTileEntity(World var1)
    {
        try
        {
            return this.machineClass.newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    //TODO: registerIcons() and getIcon()
}
