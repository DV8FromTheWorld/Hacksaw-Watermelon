package hacksaw.core.containers;

/**
 * Defines a Coordinate class.
 * Stores X and Y coordinates for GUI use.
 */
public class Coord
{
    public int Y;
    public int X;

    /**
     * Creates a Coordinate with specified values.
     * 
     * @param x
     *            The x portion of the Coord.
     * @param y
     *            The y portion of the Coord.
     */
    public Coord(int x, int y)
    {
        X = x;
        Y = y;
    }
}
