package ar.edu.ub.testing.UnitBalance;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitPropertiesTest {

    @Test
    public void testSetValidArmor() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        UnitType wizardType = new UnitType(2, "wizard");
        assertTrue(knightProperties.setArmor(wizardType, 30));

    }

    @Test
    public void testSetArmorWithNullUnitType() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        assertFalse(knightProperties.setArmor(null, 30));

    }

    @Test
    public void testSetArmorWithNegativeAmount() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        UnitType wizardType = new UnitType(2, "wizard");
        assertTrue(knightProperties.setArmor(wizardType, -60));
        assertEquals(0, knightProperties.armor(wizardType));

    }

    @Test
    public void testGetValidArmor() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        UnitType wizardType = new UnitType(2, "wizard");
        assertTrue(knightProperties.setArmor(wizardType, 30));
        assertEquals(30, knightProperties.armor(wizardType));
    }

    @Test
    public void testGetArmorWithNullType() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        UnitType wizardType = new UnitType(2, "wizard");
        assertTrue(knightProperties.setArmor(wizardType, 30));
        assertEquals(0, knightProperties.armor(null));
    }

    @Test
    public void testGetArmorWithUnknownType() {
        UnitType knightType = new UnitType(1, "Knight");
        UnitProperties knightProperties = new UnitProperties(knightType, 20, 30, 15.20f);
        UnitType bishopType = new UnitType(2, "bishop");
        assertEquals(0, knightProperties.armor(bishopType));
    }

    @Test
    public void testInitializeWithInvalidParameters() {
        UnitType wizardType = new UnitType(1, "wizard");
        UnitProperties wizardProperties = new UnitProperties(wizardType, -40, -50, -5.5f);
        assertEquals(1, wizardProperties.hitPoints());
        assertEquals(1, wizardProperties.attack());
        assertEquals(0.1f, wizardProperties.speed());
    }
    
}
