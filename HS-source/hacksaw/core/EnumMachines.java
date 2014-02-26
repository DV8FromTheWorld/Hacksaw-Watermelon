/**
 * 
 */
package hacksaw.core;

import hacksaw.core.blocks.machines.BlockMachine;
import hacksaw.core.items.ItemBlockBase;
import hacksaw.core.tileentities.TileEntityBase;
import hacksaw.core.tileentities.TileEntityGrill;
import hacksaw.core.tileentities.TileEntityGrillElectric;
import hacksaw.core.util.CoreConfiguration;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Gregory Jones
 * 
 */
public enum EnumMachines
{
    //----------- Machine Constructors --------------
    GRILL("grill", TileEntityGrill.class, HacksawGuiIds.GRILL),
    GRILL_ELECTRIC("grill.electric", TileEntityGrillElectric.class, HacksawGuiIds.GRILL_ELECTRIC);
    //-----------------------------------------------

    private final int machineId = this.ordinal();
    private int guiId = this.ordinal();
    private final String machineName;
    private boolean hasState = false;
    private ISimpleBlockRenderingHandler renderHandler = null;
    private final Class<? extends TileEntityBase> _class;
    private Icon[] iconList;

    EnumMachines(String name, Class<? extends TileEntityBase> tileClass)
    {
        this.machineName = name;
        this._class = tileClass;
        this.iconList = new Icon[6];
    }

    EnumMachines(String name, Class<? extends TileEntityBase> tileClass, int guiId)
    {
        this(name, tileClass);
        this.guiId = guiId;
    }

    EnumMachines(String name, Class<? extends TileEntityBase> tileClass, int guiId, ISimpleBlockRenderingHandler renderHandler)
    {
        this(name, tileClass, guiId);
        this.renderHandler = renderHandler;
    }

    EnumMachines(String name, Class<? extends TileEntityBase> tileClass, int guiId, ISimpleBlockRenderingHandler renderHandler, boolean hasState)
    {
        this(name, tileClass, guiId, renderHandler);
        this.hasState = hasState;
        int icons = hasState ? 12 : 6;
        this.iconList = new Icon[icons];
    }

    public int getId()
    {
        return this.machineId;
    }

    public int getGuiId()
    {
        return this.guiId;
    }

    public String getTextureName()
    {
        return CoreConfiguration.MOD_RESOURCES + ":" + this.machineName;
    }

    public String getUnlocalizedName()
    {
        return this.machineName;
    }

    public boolean hasRenderHandler()
    {
        return this.renderHandler != null;
    }

    public ISimpleBlockRenderingHandler getRenderHandler()
    {
        return this.renderHandler;
    }

    public boolean hasState()
    {
        return this.hasState;
    }

    public Icon getIcon(int side)
    {
        if (side >= 0 && side < this.iconList.length)
        {
            return this.iconList[side];
        }
        return null;
    }

    public Class<? extends TileEntityBase> getTileClass()
    {
        return this._class;
    }

    /**
     * Here is where our machine icons are registered (this can be changed /
     * ignored if we do not want to register sided icons
     * 
     * @param iconRegister
     */
    public void registerIcons(IconRegister iconRegister)
    {
        String stateString = "";
        if (this.hasState)
        {
            stateString = "_idle";
        }
        this.iconList[0] = iconRegister.registerIcon(this.getTextureName() + stateString + "_bottom");
        this.iconList[1] = iconRegister.registerIcon(this.getTextureName() + stateString + "_top");
        this.iconList[2] = iconRegister.registerIcon(this.getTextureName() + stateString + "_front");
        this.iconList[3] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
        this.iconList[4] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
        this.iconList[5] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
        if (this.hasState)
        {
            stateString = "_active";
            this.iconList[6] = iconRegister.registerIcon(this.getTextureName() + stateString + "_bottom");
            this.iconList[7] = iconRegister.registerIcon(this.getTextureName() + stateString + "_top");
            this.iconList[8] = iconRegister.registerIcon(this.getTextureName() + stateString + "_front");
            this.iconList[9] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
            this.iconList[10] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
            this.iconList[11] = iconRegister.registerIcon(this.getTextureName() + stateString + "_side");
        }
    }

    /**
     * @return total number of registered machines
     */
    public static int getSize()
    {
        return EnumMachines.values().length;
    }

    //----------- Base Machine Object and registration --------------

    public static int blockMachineId;
    public static BlockMachine blockMachine;

    public static EnumMachines getMachine(int tileId)
    {
        return tileId >= 0 && tileId < EnumMachines.values().length ? EnumMachines.values()[tileId] : null;
    }

    public static void registerMachines()
    {
        blockMachine = new BlockMachine(blockMachineId);
        GameRegistry.registerBlock(blockMachine, ItemBlockBase.class, "hswm.machine");
        for (EnumMachines machine : EnumMachines.values())
        {
            blockMachine.addMapping(machine.machineId, machine._class, machine.machineName);
        }
    }
}
