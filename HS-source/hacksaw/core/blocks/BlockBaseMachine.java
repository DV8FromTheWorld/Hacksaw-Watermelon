package hacksaw.core.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockBaseMachine extends BlockContainer
{

	/**
	 * machineClass is the TileEntity class associated with the Block Instance
	 */
	private Class machineClass;

	/**
	 * Abstract Class BlockBaseMachine
	 * 
	 * @param blockId
	 *            the ID of the Block
	 * @param machineClass
	 *            the TileEntity class associated with the Block instance
	 * @param blockIndexInTexture
	 *            the value of the texture sprite
	 */
	protected BlockBaseMachine(int blockId, Class machineClass,
			int blockIndexInTexture)
	{
		super(blockId, Material.iron);
		this.machineClass = machineClass;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	/**
	 * This return the TileEntity based on the class set in the constructor
	 */
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		try
		{
			return (TileEntity) this.machineClass.newInstance();
		}
		catch (Exception var3)
		{
			throw new RuntimeException(var3);
		}
	}

	public abstract int idDropped(int par1, Random par2Random, int par3);

	public abstract boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9);

	//TODO: registerIcons() and getIcon()
}
