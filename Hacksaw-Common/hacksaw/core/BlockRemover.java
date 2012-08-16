package hacksaw.core;

import hacksaw.core.util.HacksawDebugLoggerLevel;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.ModLoader;

import java.lang.reflect.Field;

import cpw.mods.fml.common.ReflectionHelper;

public class BlockRemover {
	
	public static boolean removeVanillaBlock(Block oldBlock) {
		for (int i = 0; i < Block.blocksList.length; i++) {
			if (Block.blocksList[i] != null) {
				if (Block.blocksList[i].blockID == oldBlock.blockID) {
					Block.blocksList[i] = null;
					ModLoader.getLogger().log(HacksawDebugLoggerLevel.HS_DEBUG, "Block ID ["+oldBlock.blockID+"] successfully removed.");
					return true;
				}
			}
		}
		ModLoader.getLogger().severe("Block ID not removed! Either the ID did not exist or was incorrect!");
		return false;
	}
}
