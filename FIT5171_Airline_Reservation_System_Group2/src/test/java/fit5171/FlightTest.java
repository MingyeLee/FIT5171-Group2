package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightTest {
    private Airplane airplane;
    private Flight flight;
    @BeforeAll
    static void initAll(){
        FlightTest flightTest = new FlightTest();
    }
    @BeforeEach
    void init() {
        flight = new Flight(123,"Beijing","Shanghai","abc","Pingguo", 10:20,200, airplane);
    }

    @Test
    void testValidFlightID(){
        int id = 123;
        int exceptResult = 123;
        flight.setFlightID(id);
        assertEquals(exceptResult, flight.getFlightID());
    }

    @Test
    void testInvalidFlightID(){
        int id = -10;
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{flight.setFlightID(id);});
        assertEquals("Flight ID should be positive number",exception.getMessage());
    }

    @Test
    void testValidDepartTo() {
        String departTo = "Beijing";
        String expectResult = "Beijing";
        flight.setDepartTo(departTo);
        assertEquals(expectResult, flight.getDepartTo());
    }

    @Test
    void testInvalidDepartTo() {
        String departTo = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo(departTo);
        });
        assertEquals("the Depart to destination cannot be empty", exception.getMessage());
    }

    @Test
    void testValidDepartFrom() {
        String departFrom = "Shanghai";
        String expectResult = "Shanghai";
        flight.setDepartFrom(departFrom);
        assertEquals(expectResult, flight.getDepartFrom());
    }

    @Test
    void testInvalidDepartFrom() {
        String departFrom = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartFrom(departFrom);
        });
        assertEquals("the Depart from place cannot be empty", exception.getMessage());
    }

    @Test
    void testValidCode() {
        String code = "abc";
        String expectResult = "abc";
        flight.setDepartFrom(code);
        assertEquals(expectResult, flight.getCode());
    }

    @Test
    void testInvalidCode() {
        String code = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setCode(code);
        });
        assertEquals("the code cannot be empty", exception.getMessage());
    }

    @Test
    void testValidCompany() {
        String company = "Pingguo";
        String expectResult = "Pingguo";
        flight.setCompany(company);
        assertEquals(expectResult, flight.getCode());
    }

    @Test
    void testInvalidCompany() {
        String company = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setCompany(company);
        });
        assertEquals("the company cannot be empty", exception.getMessage());
    }

    @Test
    void testValidDateFrom() {

    }

    @Test
    void testInvalidDateFrom() {

    }

    @Test
    void testValidDateTo() {

    }

    @Test
    void testInvalidDateTo() {

    }


//    public void setup(){
//        airplane = mock(Airplane.class);
//        flight = new Flight();
//    }
}
