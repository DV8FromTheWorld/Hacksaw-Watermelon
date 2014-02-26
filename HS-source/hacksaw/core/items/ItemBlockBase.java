package hacksaw.core.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock
{

    protected HashMap<Integer, String> itemBlockNames;
    protected ArrayList<Integer> validItemBlocks;

    public ItemBlockBase(int itemId)
    {
        super(itemId);
        itemBlockNames = new HashMap<Integer, String>();
        validItemBlocks = new ArrayList<Integer>();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    public void setMetaName(int damage, String name)
    {
        itemBlockNames.put(Integer.valueOf(damage), name);
        validItemBlocks.add(Integer.valueOf(damage));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String itemName = (String) itemBlockNames.get(Integer.valueOf(itemstack.getItemDamage()));
        if (itemName == null)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return itemName;
        }
    }

    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < validItemBlocks.size(); i++)
        {
            list.add(new ItemStack(this.itemID, 1, i));
        }
    }
}
