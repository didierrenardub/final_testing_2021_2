package ar.edu.ub.testing.UnitBalance;


/**
 * Descriptor for a unit type.
 */
public class UnitType
{
    /**
     * Constructor of the UnitType objects, which will adopt the given values.
     * 
     * @param id The ID the unit type will be identified by.
     * @param name The string representation of the type.
     */
    public UnitType(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for the unit ID.
     * 
     * @return An integer representing the ID of the unit type.
     */
    public int id()
    {
        return this.id;
    }

    /**
     * Getter for the unit type name.
     * 
     * @return The string that contains the name of the unit type.
     */
    public String name()
    {
        return this.name;
    }

    private int id;
    private String name;
}
