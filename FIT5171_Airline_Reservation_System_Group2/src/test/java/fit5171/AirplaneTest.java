package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {
    private Airplane airplane;

    @BeforeAll
    static void initAll() {
        AirplaneTest airplaneTest = new AirplaneTest();
    }

    @BeforeEach
    void init() {
        airplane = new Airplane(123, "AirBus A380", 50, 200, 10);
    }

    @Test
    void testCreateAirplaneWithValidID() {
        assertNotNull(new Airplane(123, "AirBus A380", 50, 200, 10));
    }

    @Test
    void testCreateAirplaneWithInvalidID() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(-123, "AirBus A380", 50, 200, 10);
        });
        assertEquals("Airplane ID should be positive number", e.getMessage());
    }

    @Test
    void testCreateAirplaneWithInvalidBusinessSitsNumber() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(123, "AirBus A380", -50, 200, 10);
        });
        assertEquals("businessSitsNumber should be within 1-300", e.getMessage());
    }

    @Test
    void testCreateAirplaneWithInvalidEconomySitsNumber() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(123, "AirBus A380", 50, -200, 10);
        });
        assertEquals("economySitsNumber should be within 1-300", e.getMessage());
    }

    @Test
    void testCreateAirplaneWithInvalidCrewSitsNumber() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(123, "AirBus A380", 50, 200, -10);
        });
        assertEquals("crewSitsNumber should be within 1-300", e.getMessage());
    }

    @Test
    void testCreateAirplaneWithTotalSitsNumberExceed300() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(123, "AirBus A380", 50, 250, 10);
        });
        assertEquals("Total sits number cannot exceed 300", e.getMessage());
    }

    @Test
    void testSetValidAirplaneID() {
        int id = 456;
        int exceptResult = 456;
        airplane.setAirplaneID(id);
        assertEquals(exceptResult, airplane.getAirplaneID());
    }

    @Test
    void testSetInvalidAirplaneID() {
        int id = -10;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneID(id);
        });
        assertEquals("Airplane ID should be positive number", exception.getMessage());
    }

    @Test
    void testValidModel() {
        String model = "Boeing 747";
        String expectResult = "Boeing 747";
        airplane.setAirplaneModel(model);
        assertEquals(expectResult, airplane.getAirplaneModel());
    }

    @Test
    void testInvalidModel() {
        String model = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneModel(model);
        });
        assertEquals("Airplane Model cannot be empty", exception.getMessage());
    }

    @Test
    void testValidBusinessSitsNumber() {
        int number = 10;
        int expectResult = 10;
        airplane.setBusinessSitsNumber(number);
        assertEquals(expectResult, airplane.getBusinessSitsNumber());
    }

    @Test
    void testInvalidBusinessSitsNumber() {
        int number = -10;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setBusinessSitsNumber(number);
        });
        assertEquals("businessSitsNumber should be within 1-300", exception.getMessage());
    }

    @Test
    void testValidEconomySitsNumber() {
        int number = 100;
        int expectResult = 100;
        airplane.setEconomySitsNumber(number);
        assertEquals(expectResult, airplane.getEconomySitsNumber());
    }

    @Test
    void testInvalidEconomySitsNumber() {
        int number = -1;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setEconomySitsNumber(number);
        });
        assertEquals("economySitsNumber should be within 1-300", exception.getMessage());
    }

    @Test
    void testValidCrewSitsNumber() {
        int number = 10;
        int expectResult = 10;
        airplane.setCrewSitsNumber(number);
        assertEquals(expectResult, airplane.getCrewSitsNumber());
    }

    @Test
    void testInvalidCrewSitsNumber() {
        int number = -10;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(number);
        });
        assertEquals("crewSitsNumber should be within 1-300", exception.getMessage());
    }

    @Test
    void testTotalSitsNumberNotExceed300() {
        int businessSitsNumber = 10;
        int economySitsNumber = 250;
        int crewSitsNumber = 12;
        int expectedResult = businessSitsNumber + economySitsNumber + crewSitsNumber;
        airplane.setBusinessSitsNumber(businessSitsNumber);
        airplane.setEconomySitsNumber(economySitsNumber);
        airplane.setCrewSitsNumber(crewSitsNumber);
        assertEquals(expectedResult, airplane.getBusinessSitsNumber() + airplane.getEconomySitsNumber() + airplane.getCrewSitsNumber());
    }

    @Test
    void testTotalSitsNumberExceed300() {
        int businessSitsNumber = 50;
        int economySitsNumber = 240;
        int crewSitsNumber = 12;
        int expectedResult = businessSitsNumber + economySitsNumber + crewSitsNumber;
        airplane.setBusinessSitsNumber(businessSitsNumber);
        airplane.setEconomySitsNumber(economySitsNumber);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(crewSitsNumber);
        });
        assertEquals("Total sits number cannot exceed 300", exception.getMessage());
    }
}
