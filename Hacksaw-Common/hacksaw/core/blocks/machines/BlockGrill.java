package hacksaw.core.blocks.machines;

import hacksaw.core.HacksawBlocks;
import hacksaw.core.HacksawGuiIds;
import hacksaw.core.mod_Hacksaw;
import hacksaw.core.machines.tileentities.TileEntityGrill;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class BlockGrill extends BlockContainer{

	protected BlockGrill(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityGrill();
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return HacksawBlocks.grill.blockId;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	TileEntityGrill var10 = (TileEntityGrill) world.getBlockTileEntity(x, y, z);
    	
    	if(!world.isRemote){
    			player.openGui(mod_Hacksaw.INSTANCE, HacksawGuiIds.GRILL, world, x, y, z);
    			return true;
    	}else{
    		return false;
    	}
    	
    }  
    
    
}
