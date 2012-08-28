package hacksaw.core.items.tools;

import hacksaw.core.items.ItemBaseChefTools;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemKnifeSharpener extends ItemBaseChefTools {

	public ItemKnifeSharpener(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(10);
		this.setIconCoord(2, 0);
		this.setItemName("knife.sharpener");
	}
	
	@Override
	public Item getContainerItem(){
		return this;
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return true;
	}
}