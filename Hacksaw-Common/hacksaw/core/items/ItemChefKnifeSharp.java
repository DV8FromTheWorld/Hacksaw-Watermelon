package hacksaw.core.items;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemChefKnifeSharp extends Item {
	
	public ItemChefKnifeSharp(int i) {
		super(i);
		this.setMaxStackSize(1);
		this.setMaxDamage(45);
		this.setItemName("sharp.chef.knife");
		this.setIconCoord(0, 0);
	}

	@Override
	public Item getContainerItem(){
		return this;
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
		System.out.println("ItemStack: " +String.valueOf(par1ItemStack));
		System.out.println("EntityPlayer: " +String.valueOf(par2EntityPlayer));
		System.out.println("world: " +String.valueOf(par3World));
		System.out.println("int par4: " +String.valueOf(par4));
		System.out.println("int par5: " +String.valueOf(par5));
		System.out.println("int par6: " +String.valueOf(par6));
		System.out.println("int par7: " +String.valueOf(par7));
		par1ItemStack.stackSize--;
        return true;
    }

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;
	}
}
