package ar.edu.ub.testing.UnitBalance.tests;

import ar.edu.ub.testing.UnitBalance.UnitType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTypeTest {
    UnitType test_unitType;
    UnitType test_unitType2;

    @Test
    void Test_New_Valid_Unit_Type(){
        test_unitType = new UnitType(1,"Chariot");

        assertEquals("Chariot",test_unitType.name());
    }
    @Test
    void Test_Assert_Exception_On_New_Unit_Type_With_Empty_String() {
        test_unitType = new UnitType(2, "");

        assertThrows(RuntimeException.class, () -> test_unitType.name(), "A Unit must have a name");
    }

    @Test
    void Test_Assert_Exception_On_New_Units_With_Repeated_IDs(){
        test_unitType = new UnitType(1,"Man at arms");
        test_unitType2 = new UnitType(1,"Villager");

        assertThrows(RuntimeException.class, () -> test_unitType2.id(), "A Unit must have a unique Id");
    }
    @Test
    void Test_New_Units_With_repeated_IDs_and_Empty_Strings(){
        test_unitType = new UnitType(1,"");
        test_unitType2 = new UnitType(1,"");

        assertEquals(1,test_unitType.id());
        assertEquals("",test_unitType.name());

        assertEquals(1,test_unitType2.id());
        assertEquals("",test_unitType2.name());
    }

    @Test
    void Test_Assert_Exception_On_Negative_Id_Number(){
        test_unitType = new UnitType(-1,"Paladin");

        assertThrows(RuntimeException.class, () -> test_unitType2.id(), "A Unit Id cannot be Negative");
    }

    @Test
    void Test_Negative_Id_Number(){
        test_unitType = new UnitType(-1,"Scout");

        assertEquals(-1,test_unitType.id());
    }

}