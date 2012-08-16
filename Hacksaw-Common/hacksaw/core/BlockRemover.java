package hacksaw.core;

import hacksaw.core.util.HacksawDebugLoggerLevel;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.ModLoader;

import java.lang.reflect.Field;

import cpw.mods.fml.common.ReflectionHelper;

public class BlockRemover {
	
	public static boolean removeVanillaBlock(Block oldBlock) {
		// if the the block in blocksList with the blockID of the oldBlock is initialized
		if (Block.blocksList[oldBlock.blockID] != null) {
			// Set the block in the blocksList to null
			Block.blocksList[oldBlock.blockID] = null;
			// Output a success message
			ModLoader.getLogger().log(HacksawDebugLoggerLevel.HS_DEBUG, "Block ID ["+oldBlock.blockID+"] successfully removed.");
			return true;
		} else {
			// Output a failure message
			ModLoader.getLogger().severe("Block ID not removed! Either the ID did not exist or was incorrect!");
			return false;
		}
	}
}
