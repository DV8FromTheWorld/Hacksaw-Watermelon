package hacksaw.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MeatProvider{
	private static MeatProvider INSTANCE = new MeatProvider();
	public MeatProvider() {	}
	public static MeatProvider getInstance() {
		return INSTANCE;
	}

	@ForgeSubscribe
	public void LivingDropEvent(LivingDropsEvent event) {
		if(event.entity instanceof EntitySheep){
			if(!event.entityLiving.isChild()){
				if(event.entityLiving.isBurning()){
					event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(HacksawItems.lambChopCooked.item, 1)));
				}else{
					event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(HacksawItems.lambChopRaw.item, 1)));
				}		
			}
		}					
	}
	
	/*@ForgeSubscribe
    public void CommandEvent(CommandEvent event)
    {
    	
    }*/

}