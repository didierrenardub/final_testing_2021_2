package ar.edu.ub.testing.UnitBalance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitTest {

    @Test
    public void testDamageAgainstWithoutBonusDamage() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        UnitType wizardType = new UnitType(2, "wizard");
        UnitProperties wizardPropierties = new UnitProperties(wizardType, 500, 5, 1.0f);
        wizardPropierties.setArmor(knightType, 10);
        Unit knight = new Unit(knightProperties);
        Unit wizard = new Unit(wizardPropierties);
        assertEquals(90, knight.damageAgainst(wizard));
    }

    @Test
    public void testDamageAgainstWithBonusdamage() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        UnitType wizardType = new UnitType(2, "wizard");
        UnitProperties wizardPropierties = new UnitProperties(wizardType, 500, 5, 1.0f);
        wizardPropierties.setArmor(knightType, 10);
        Unit knight = new Unit(knightProperties);
        knight.setBonusDamage(wizardType, 5);
        Unit wizard = new Unit(wizardPropierties);
        assertEquals(95, knight.damageAgainst(wizard));
    }


    @Test
    public void testDamageAgainstWithoutProperties() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        UnitType wizardType = new UnitType(2, "wizard");
        Unit knight = new Unit(knightProperties);
        Unit wizard = new Unit(null);
        assertEquals(1, knight.damageAgainst(wizard));
    }

    @Test
    public void testDamageAgainstWithoutUnit() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        Unit knight = new Unit(knightProperties);
        assertEquals(1, knight.damageAgainst(null));
    }

    @Test
    public void testTimeToDefeat() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 2.00f);
        UnitType wizardType = new UnitType(2, "wizard");
        UnitProperties wizardPropierties = new UnitProperties(wizardType, 500, 5, 1.0f);
        wizardPropierties.setArmor(knightType, 10);
        Unit knight = new Unit(knightProperties);
        Unit wizard = new Unit(wizardPropierties);
        assertEquals(2.77f, knight.timeToDefeat(wizard));

    }

    @Test
    public void testTimeToDefeatWithNullUnit() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        Unit knight = new Unit(knightProperties);
        assertEquals(0.0f, knight.timeToDefeat(null));
    }

    @Test
    public void testDefeats() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 2.00f);
        UnitType wizardType = new UnitType(2, "wizard");
        UnitProperties wizardPropierties = new UnitProperties(wizardType, 500, 5, 1.0f);
        wizardPropierties.setArmor(knightType, 10);
        Unit knight = new Unit(knightProperties);
        Unit wizard = new Unit(wizardPropierties);
        assertTrue(knight.defeats(wizard));
        assertFalse(wizard.defeats(knight));
    }

    @Test
    public void testDefeatsWithoutUnit() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 500, 100, 10.00f);
        Unit knight = new Unit(knightProperties);
        assertTrue(knight.defeats(null));
    }

    
}
