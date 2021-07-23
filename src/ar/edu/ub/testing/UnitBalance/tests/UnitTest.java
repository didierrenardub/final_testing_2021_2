package ar.edu.ub.testing.UnitBalance.tests;

import ar.edu.ub.testing.UnitBalance.Unit;
import ar.edu.ub.testing.UnitBalance.UnitProperties;
import ar.edu.ub.testing.UnitBalance.UnitType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    UnitProperties properties;
    UnitType types;
    Unit New_Unit;

    @BeforeEach
    void setUp(){
        types = new UnitType(1,"Valid name");
        properties = new UnitProperties(types,10,8,5);
        New_Unit = new Unit(properties);
    }

    @Test
    void Test_New_Unit_Constructor_Name(){

        assertEquals("Valid name",New_Unit.properties().type().name());
    }

    @Test
    void Test_Valid_Set_Bonus_Damage(){

        assertTrue(New_Unit.setBonusDamage(types,2));
    }
    @Test
    void Test_Null_Set_Bonus_Damage(){

        assertFalse(New_Unit.setBonusDamage(null,2));
    }
    @Test
    void Test_Damage_Against_Enemy_Unit(){
        Unit Enemy_Unit = new Unit(properties);
        New_Unit.setBonusDamage(types,2);
        Enemy_Unit.properties().setArmor(types,5);

        assertEquals(5,New_Unit.damageAgainst(Enemy_Unit));
    }

    @Test
    void Test_Time_To_Defeat_In_Seconds() {
        Unit Enemy_Unit = new Unit(properties);
        New_Unit.properties().setArmor(types, 6);
        New_Unit.setBonusDamage(types,2);
        Enemy_Unit.properties().setArmor(types,5);

        assertEquals(10,New_Unit.timeToDefeat(Enemy_Unit));
    }
    @Test
    void Test_New_Unit_Defeats_Enemy_Unit(){
        Unit Enemy_Unit = new Unit(properties);
        New_Unit.properties().setArmor(types, 6);
        New_Unit.setBonusDamage(types,2);
        Enemy_Unit.properties().setArmor(types,5);
        New_Unit.timeToDefeat(Enemy_Unit);

        assertTrue(New_Unit.defeats(Enemy_Unit));
    }


}