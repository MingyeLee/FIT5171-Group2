package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightTest {
    Airplane airplane;
    Flight flight;
    @BeforeAll
    public void setup(){
        airplane = mock(Airplane.class);
        flight = new Flight();
    }
}
