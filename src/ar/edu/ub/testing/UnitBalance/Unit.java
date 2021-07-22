package ar.edu.ub.testing.UnitBalance;

import java.util.HashMap;


/**
 * Describes properties of a unit and allows evaluating match ups between different ones.
 */
public class Unit
{
    /**
     * Initialize the current unit with the given properties.
     * 
     * @param properties A UnitProperties object that holds the values for the unit's characteristics. Should not be null.
     */
    public Unit(UnitProperties properties)
    {
        this.properties = properties;
        this.bonusDamage = new HashMap<UnitType, Integer>();
    }

    /**
     * Getter for the object holding the properties for the current unit.
     * 
     * @return The UnitProperties object holding the values for the different characteristics of the current unit.
     */
    public UnitProperties properties()
    {
        return this.properties;
    }

    /**
     * Helps configuring the armor values against the different attack types.
     * 
     * @param forUnitType The type the armor will block damage from. UnitType is used for that. Shouldn't be null.
     * @param amount Amount of armor against the given type the unit will be granted. Cannot be less than 0.
     * @return A boolean confirming whether or not the armor value has been set or not.
     */
    public boolean setBonusDamage(UnitType forUnitType, Integer amount)
    {
        if (forUnitType != null)
        {
            bonusDamage.put(forUnitType, Math.max(0, amount));
            return true;
        }

        return false;
    }

    /**
     * Calculate the real damage the current unit deals to another unit.
     * 
     * The formula is: A1 - D2 + B1
     * Where:
     *      A: Attack
     *      D: Armor
     *      B: Bonus damage
     * 
     * @param other The unit to calculate the damage against.
     * @return The amount of damage one attack will deal to the given unit. Cannot be less than 1.
     */
    public int damageAgainst(Unit other)
    {
        if (other != null && this.properties() != null && other.properties() != null)
        {
            return Math.max(1, this.properties().attack() - other.properties().armor(this.properties().type()) + this.bonusDamage.get(other.properties().type(), 0));
        }

        return 1;
    }

    /**
     * Calculates the time the current unit would take to defeat the provided one.
     * 
     * @param other The unit to have the time to defeat it calculated.
     * @return The time it'll take to bring the given unit down, in seconds.
     */
    public float timeToDefeat(Unit other)
    {
        if (other != null && this.properties() != null && other.properties() != null)
        {
            return other.properties().hitPoints() / this.damageAgainst(other) * this.properties().speed();
        }

        return 0.0f;
    }

    /**
     * Tells whether the current unit can defeat a given one based on the time it takes each to bring down the other.
     *  
     * @param other The unit to check if it can be defeated by the current one.
     * @return True if the current unit can defeat the given one, false otherwise.
     */
    public boolean defeats(Unit other)
    {
        return (other == null) || (this.timeToDefeat(other) < other.timeToDefeat(this));
    }

    private UnitProperties properties;
    private HashMap<UnitType, Integer> bonusDamage;
}
