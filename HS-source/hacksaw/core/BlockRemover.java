package hacksaw.core;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import hacksaw.core.util.HacksawLogger;
import hacksaw.core.util.HacksawLogger.LogLevel;

public class BlockRemover {
	
	public static boolean removeVanillaBlock(Block oldBlock) {
		// if the the block in blocksList with the blockID of the oldBlock is initialized
		if (Block.blocksList[oldBlock.blockID] != null) {
			// Checks if the block is also has an ItemBlock associated with it
			if (ItemBlock.itemsList[oldBlock.blockID] != null) {
				ItemBlock.itemsList[oldBlock.blockID] = null;
			}
			// Set the block in the blocksList to null
			Block.blocksList[oldBlock.blockID] = null;
			// Output a success message
			HacksawLogger.log(LogLevel.DEBUG, "Block ID ["+oldBlock.blockID+"] successfully removed.");
			return true;
		} else {
			// Output a failure message
			HacksawLogger.log(LogLevel.SEVERE, "Block ID not removed! Either the ID did not exist or was incorrect!");
			return false;
		}
	}
}
