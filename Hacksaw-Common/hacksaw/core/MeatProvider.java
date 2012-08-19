package hacksaw.core;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.forge.IEntityLivingHandler;

public class MeatProvider implements IEntityLivingHandler {
	private static MeatProvider INSTANCE = new MeatProvider();
	private MeatProvider() {}
	public static MeatProvider getInstance() {
		return INSTANCE;
	}

	public void registerDrops( ) {
		
	}

	public void onEntityLivingDrops( EntityLiving entity, DamageSource source, ArrayList<EntityItem> drops, int lootingLevel, boolean recentlyHit, int specialDropValue ) {
		// meat goes here
		/*if(entity instanceof EntitySheep){
			if(!entity.isChild()){
				Random generator = new Random();
				int Chance =  generator.nextInt(5);
				//if(Chance < 4){
					if(entity.isBurning()){
						drops.add(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, new ItemStack(HacksawItems.lambChopCooked.item, 1)));
					}else{
						drops.add(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, new ItemStack(HacksawItems.lambChopRaw.item, 1)));
					}
				//}
				
			}
		}*/						//Not sure why, but the code above does not seem to work...
		
		
	}

	// irrelevant interface stuff

	public boolean onEntityLivingAttacked( EntityLiving entity, DamageSource attack, int damage ) {
		return false;
	}
	public boolean onEntityLivingDeath( EntityLiving entity, DamageSource killer ) {
		return true;
	}
	public boolean onEntityLivingFall( EntityLiving entity, float distance ) {
		return false;
	}
	public int onEntityLivingHurt( EntityLiving entity, DamageSource source, int damage ) {
		return damage;
	}
	public void onEntityLivingJump( EntityLiving entity ) {
		return;
	}
	public void onEntityLivingSetAttackTarget( EntityLiving entity, EntityLiving target ) {
		return;
	}
	public boolean onEntityLivingSpawn( EntityLiving entity, World world, float x, float y, float z ) {
		return false;
	}
	public boolean onEntityLivingUpdate( EntityLiving entity ) {
		return false;
	}
}