package hacksaw.core.blocks.machines;

import hacksaw.core.HacksawGuiIds;
import hacksaw.core.blocks.BlockBaseMachine;
import hacksaw.core.machines.tileentities.TileEntityGrill;



public class BlockGrill extends BlockBaseMachine
{

    public BlockGrill(int blockId)
    {
        super(blockId, TileEntityGrill.class, HacksawGuiIds.GRILL);
    }
}
