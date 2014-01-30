package hacksaw.api;

public interface IGrillable
{

    /**
     * Needs to return the amount to time that the food should be cooked
     * if return = -1, it will cook for the default minecraft cook time
     * Return a time in seconds
     * 
     * @return
     */
    int getCookingTime();

    /**
     * Return the shifted index of the cooked food
     * 
     * @return
     */
    int getCookedItemId();

}
