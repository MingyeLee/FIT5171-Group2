package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    public void setup() {
        airplane = new Airplane(7,"Airbus A380",130,341,24);
    }

    @Test
    public void testGetAirplaneID(){
        assertEquals(7,airplane.getAirplaneID());
    }
}
