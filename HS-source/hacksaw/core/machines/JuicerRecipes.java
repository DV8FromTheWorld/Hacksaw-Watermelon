package hacksaw.core.machines;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class JuicerRecipes
{

    //Created for future use.  Absolutely no implementation as of yet.
    private static final JuicerRecipes INSTANCE = new JuicerRecipes();
    public static HashMap<Integer, ItemStack> foodToJuice = new HashMap<Integer, ItemStack>();
    public static HashMap<Integer, Integer> timeToJuice = new HashMap<Integer, Integer>();

    private JuicerRecipes()
    {

    }

    public static JuicerRecipes getInstance()
    {
        return INSTANCE;
    }

    public static void addToJuicerToJuice(int input, ItemStack output, float experienceOnComplete)
    {
        addToJuicerToJuice(input, output, -1, experienceOnComplete);
    }

    public static void addToJuicerToJuice(int input, ItemStack output, int juiceTime, float experienceOnComplete)
    {
        //----temp----
        GameRegistry.addSmelting(input, output, experienceOnComplete);
        //----/temp----
        foodToJuice.put(input, output);
        timeToJuice.put(input, juiceTime);

    }

    public HashMap<Integer, Integer> getJuiceTimes()
    {
        return timeToJuice;
    }

    public HashMap<Integer, ItemStack> getFoodToJuice()
    {
        return foodToJuice;
    }

}
