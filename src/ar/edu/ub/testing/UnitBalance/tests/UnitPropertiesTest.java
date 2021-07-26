package ar.edu.ub.testing.UnitBalance.tests;

import ar.edu.ub.testing.UnitBalance.UnitProperties;
import ar.edu.ub.testing.UnitBalance.UnitType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitPropertiesTest {

    UnitProperties properties;


    @Test
    void Test_New_Valid_Properties(){
        UnitType Types = new UnitType(10,"Paladin");
        properties = new UnitProperties(Types,10,10,2);

        assertEquals(10,properties.attack());
        assertEquals(10,properties.hitPoints());
        assertEquals(2,properties.speed());
        assertEquals("Paladin",properties.type().name());

    }
    @Test
    void Test_Negative_Properties(){
        UnitType Types = new UnitType(1,"");
        properties = new UnitProperties(Types,-10,-10,-10);

        assertEquals(1,properties.hitPoints());
        assertEquals(1,properties.attack());
        assertEquals(1,properties.hitPoints());
        assertEquals(0.1f,properties.speed());

    }

    @Test //Test de Set Armor y del HashMap armorValues comprobando que properties.armor puede acceder al map devolviendo el valor
    void Test_New_Valid_settingValidArmor(){
        UnitType Types = new UnitType(5,"Monk");
        properties = new UnitProperties(Types,10,10,2);
        properties.setArmor(Types,5);

        assertEquals(5,properties.armor(Types));
    }

    @Test
    void Test_Null_Set_Armor(){
        properties = new UnitProperties(null,10,10,2);
        properties.setArmor(null,null);

        assertEquals(0,properties.armor(null));
    }
    @Test
    void Test_Negative_Set_Armor(){
        properties = new UnitProperties(null,10,10,2);
        properties.setArmor(null,-10);

        assertEquals(0,properties.armor(null));
    }





}