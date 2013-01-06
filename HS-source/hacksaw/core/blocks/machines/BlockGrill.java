package hacksaw.core.blocks.machines;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawGuiIds;
import hacksaw.core.mod_Hacksaw;
import hacksaw.core.blocks.BlockBaseMachine;
import hacksaw.core.machines.tileentities.TileEntityGrill;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGrill extends BlockBaseMachine {
	
	public BlockGrill(int blockId, Class grillClass, int blockIndexInTexture) {
		super(blockId, grillClass, blockIndexInTexture);
	}
	
	@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return HacksawBlocks.grill.blockId;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	TileEntity tileentity = world.getBlockTileEntity(x, y, z);
    	if (tileentity != null && tileentity instanceof TileEntityGrill) {
    		TileEntityGrill tileentitygrill = (TileEntityGrill) tileentity;
    	
	    	if(!world.isRemote){
	    			player.openGui(mod_Hacksaw.INSTANCE, HacksawGuiIds.GRILL, world, x, y, z);
	    			return true;
	    	}
    	}
    	return false;
    }  
    
    
}
