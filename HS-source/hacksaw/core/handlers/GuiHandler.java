package hacksaw.core.handlers;

import hacksaw.core.HacksawGuiIds;
import hacksaw.core.containers.ContainerGrill;
import hacksaw.core.gui.GuiGrill;
import hacksaw.core.tileentities.TileEntityGrill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        switch(ID)
        {
            case HacksawGuiIds.GRILL:
                if (tileEntity instanceof TileEntityGrill)
                {
                    return new ContainerGrill(player.inventory, (TileEntityGrill)tileEntity);
                }  
                break;
            case HacksawGuiIds.GRILL_ELECTRIC:
                break;
            case HacksawGuiIds.JUICER:
                break;
            case HacksawGuiIds.JUICER_ELECTRIC:
                break;
        }
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        switch(ID)
        {
            case HacksawGuiIds.GRILL:
                if (tileEntity instanceof TileEntityGrill)
                {
                    return new GuiGrill(player.inventory, (TileEntityGrill)tileEntity);
                }  
                break;
            case HacksawGuiIds.GRILL_ELECTRIC:
                break;
            case HacksawGuiIds.JUICER:
                break;
            case HacksawGuiIds.JUICER_ELECTRIC:
                break;
        }
        return null;
    }
}
