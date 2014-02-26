package hacksaw.core.blocks.machines;

import hacksaw.core.EnumMachines;
import hacksaw.core.mod_Hacksaw;
import hacksaw.core.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Gregory Jones
 * 
 */
public class BlockMachine extends BlockBase
{

    public BlockMachine(int blockId)
    {
        // Using our Enum size we can create a Block object with containing Tile Entities
        super(blockId, Material.iron, EnumMachines.getSize());
    }

    @Override
    protected void registerBlockIcons(IconRegister iconRegister)
    {
        for (int i = 0; i < this.tileEntityMap.length; i++)
        {
            EnumMachines.getMachine(i).registerIcons(iconRegister);
        }
    }

    @Override
    protected Icon getIconFromSideAndMetadata(int side, int metadata)
    {
        // We attempt to retrieve a machine from our list
        EnumMachines machine = EnumMachines.getMachine(metadata);
        // If we retrieve a machine we attempt to get the icon, otherwise return the default
        return machine != null ? machine.getIcon(side) : this.blockIcon;
    }

    @Override
    protected Icon getBlockTextureAt(IBlockAccess iblockaccess, int x, int y, int z, int side)
    {
        // For now we will assume no changes to the block Icons
        // We will eventually implement icons based on the rotation of the block
        return this.getIcon(side, iblockaccess.getBlockMetadata(x, y, z));
    }

    @Override
    protected boolean doBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        // Skip if client
        if (world.isRemote)
        {
            return true;
        }
        // Get the tileentity at the location x, y, z and compare with the tileentity we should have based on metadata
        int metadata = world.getBlockMetadata(x, y, z);
        TileEntity tileEntity = (TileEntity) getTileEntity(world, x, y, z, this.getTileMapData(metadata));

        // If the player is not sneaking and our comparisson passed open a gui
        if (!player.isSneaking() && tileEntity != null)
        {
            // We retrieve the GUI ID from our Machine Enum
            int guiID = EnumMachines.getMachine(metadata).getGuiId();
            player.openGui(mod_Hacksaw.INSTANCE, guiID, world, x, y, z);
            return true;
        }
        return false;
    }

}
