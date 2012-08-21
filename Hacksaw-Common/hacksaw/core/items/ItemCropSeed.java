package hacksaw.core.items;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.forge.ITextureProvider;

public abstract class ItemCropSeed extends Item implements ITextureProvider {

	public ItemCropSeed(int id) {
		super(id);
	}
	
	// return the block we turn into when planted
	public abstract int getCropBlockID();
	
	// return the type of soil we can plant in
	public abstract int getSoilBlockID();
	
	/**
	 * Called whenever we attempt to right click with a seed.
	 * 
	 * @param itemStack Seeds in question.
	 * @param player Player performing the action.
	 * @param world Current world.
	 * @param x X coordinate.
	 * @param z Z coordinate.
	 * @param y Y coordinate.
	 * @param face side of item.
	 * @return
	 */
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int z, int y, int face)
    {
		if( face != 1 ) {
			// unless we're clicking on the top of the block, it's a failure
			return false;
		} else if( player.canPlayerEdit(x, z, y) && player.canPlayerEdit(x, z+1, y) ) {
			// only fire if we can modify the block targetted and the one directly above it is air
			int targetBlockId = world.getBlockId(x, z, y);
			if( targetBlockId == this.getSoilBlockID() && world.isAirBlock(x, z+1, y) ) {
				// place the plant
				world.setBlockWithNotify(x, z+1, y, this.getCropBlockID());
				// decrement our stack
				--itemStack.stackSize;
				return true;
			}
		}
		// invalid case, we didn't do anything
        return false;
    }
	
	@Override
	// To add the 'crop.' String as a prefix to Hacksaw crop items
	public Item setItemName(String itemName) {
		String newname = "crop." + itemName;
		return super.setItemName(newname);
	}

	@Override
	public void addCreativeItems(ArrayList itemList){
		itemList.add(new ItemStack(this, 1));
	}
	
	@Override
	public String getTextureFile(){
		return "/hacksaw/textures/seeds.png";
	}

}
