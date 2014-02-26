package hacksaw.core;

import net.minecraft.block.Block;

public enum EnumVegetation
{
    //----------- Vegetation ------------
    MELON(""),
    SAPLING_APPLE(""),
    CROP_CARROT(""),
    CROP_LETTUCE("");

    public int blockId;
    public int renderId;
    public String name;
    public Block block;

    EnumVegetation(String name)
    {
        this.name = name;
    }
}
