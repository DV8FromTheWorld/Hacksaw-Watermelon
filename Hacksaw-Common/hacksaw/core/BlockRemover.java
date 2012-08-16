package hacksaw.core;

import hacksaw.core.util.HacksawDebugLoggerLevel;

import java.util.List;

import net.minecraft.src.Block;
import java.lang.reflect.Field;

import cpw.mods.fml.common.ReflectionHelper;

public class BlockRemover {
	
	public static boolean removeVanillaBlock(Block oldBlock) {
		for (int i = 0; i < Block.blocksList.length; i++) {
			if (Block.blocksList[i] != null) {
				if (Block.blocksList[i].blockID == oldBlock.blockID) {
					Block.blocksList[i] = null;
					HacksawDebugLoggerLevel.log("Block ID ["+oldBlock.blockID+"] successfully removed.", HacksawDebugLoggerLevel.LogLevel.FINE);
					return true;
				}
			}
		}
		HacksawDebugLoggerLevel.log("Block ID not removed! Either the ID did not exist or was incorrect!", HacksawDebugLoggerLevel.LogLevel.SEVERE);
		return false;
	}
}
