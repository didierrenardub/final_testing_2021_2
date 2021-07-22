package ar.edu.ub.testing.UnitBalance;

import java.util.HashMap;


/**
 * Bundles the properties of the different untis together.
 */
class UnitProperties
{
    /**
     * Initializes the properties with the given values, except for the armor values
     * which should be manually set afterwards using the setArmor method.
     * 
     * @param type The type the unit is identified with. Shouldn't be null.
     * @param hitPoints Amount of hit points the unit has. Can't be less than 1.
     * @param attack How much damage the unit deals while attacking. Can't be less than 1.
     * @param speed Attack speed, measured in seconds. Can't be less than 0.1.
     */
    public UnitProperties(UnitType type, int hitPoints, int attack, float speed)
    {
        this.type = type;
        this.hitPoints = Math.max(1, hitPoints);
        this.attack = Math.max(1, attack);
        this.speed = Math.max(0.1f, speed);
        this.armorValues = new HashMap<UnitType, Integer>();
    }

    /**
     * Getter for the unit type.
     * 
     * @return The type of the unit.
     */
    public UnitType type()
    {
        return this.type;
    }

    /**
     * Getter for the total amount of hit points the unit has.
     * 
     * @return An integer representing the amount of hit points the unit has.
     */
    public int hitPoints()
    {
        return this.hitPoints;
    }

    /**
     * Getter for the attack value the unit has.
     * 
     * @return An integer representing the amount of damage the unit deals per attack.
     */
    public int attack()
    {
        return this.attack;
    }

    /**
     * Getter for the unit's attack speed.
     * 
     * @return A float representing how much time it takes the unit to perform an attack.
     */
    public float speed()
    {
        return this.speed;
    }

    /**
     * Allows configuring an amount of armor against attacks from a certain unit type.
     * 
     * @param ofType The unit type the armor applies against. Should not be null.
     * @param amount The armor that the unit will have against the given type. Cannot be less than 0.
     * @return A boolean telling whether the value has been set or not.
     */
    public boolean setArmor(UnitType ofType, Integer amount)
    {
        if (ofType != null)
        {
            this.armorValues.put(ofType, Math.max(0, amount));
            return true;
        }

        return false;
    }

    /**
     * Getter to retrieve the armor the current unit has against a certain type of unit attack.
     * 
     * @param ofType The type the armor value should be retrieved for.
     * @return The armor value the current unit has against the given unit type's attack. Never less than 0.
     */
    public int armor(UnitType ofType)
    {
        if (ofType != null)
        {
            return this.armorValues.getOrDefault(ofType, 0);
        }

        return 0;
    }

    private UnitType type;
    private int hitPoints;
    private int attack;
    private float speed;
    private HashMap<UnitType, Integer> armorValues;
}
