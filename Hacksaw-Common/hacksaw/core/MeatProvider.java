package hacksaw.core;

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
		return;
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