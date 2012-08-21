package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemCropSeed extends Item implements ITextureProvider{

	public ItemCropSeed(int par1) {
		super(par1);
	}
	
	// return the block we turn into when planted
	public abstract int getCropBlockID();
	
	// return the type of soil we can plant in
	public abstract int getSoilBlockID();
	
	/**
	 * Called whenever we attempt to right click with a seed.
	 * 
	 * @param par1ItemStack Seeds in question.
	 * @param par2EntityPlayer Player performing the action.
	 * @param par3World Current world.
	 * @param par4 X coordinate.
	 * @param par5 Z coordinate.
	 * @param par6 Y coordinate.
	 * @param par7 side of item.
	 * @return
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
		if( par7 != 1 ) {
			// unless we're clicking on the top of the block, it's a failure
			return false;
		} else if( par2EntityPlayer.canPlayerEdit(par4, par5, par6) && par2EntityPlayer.canPlayerEdit(par4, par5+1, par6) ) {
			// only fire if we can modify the block targetted and the one directly above it is air
			int targetBlockId = par3World.getBlockId(par4, par5, par6);
			if( targetBlockId == this.getSoilBlockID() && par3World.isAirBlock(par4, par5+1, par6) ) {
				// place the plant
				par3World.setBlockWithNotify(par4, par5+1, par6, this.getCropBlockID());
				// decrement our stack
				--par1ItemStack.stackSize;
				return true;
			}
		}
		// invalid case, we didn't do anything
        return false;
    }

	@Override
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
	
	@Override
	public String getTextureFile(){
		return "/hacksaw/textures/items.png";
	}

}
