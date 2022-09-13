package fit5171;

import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuyTicketTest {
    BuyTicket buyTicket;
    Passenger passenger;
    Flight flight;
    Ticket ticket;

    @BeforeAll
    public void setup() {
        passenger = mock(Passenger.class);
        flight = mock(Flight.class);
        ticket = mock(Ticket.class);
        buyTicket = new BuyTicket(passenger, flight, ticket);
    }

    @Test
    public void testShowTicketWithValidTicket() {

        Timestamp dateFrom = new Timestamp(1662986289);
        Timestamp dateTo = new Timestamp(166298999);
        Airplane airplane = mock(Airplane.class);
        when(ticket.getFlight()).thenReturn(new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", null, null, airplane));
        assertEquals(true, buyTicket.showTicket());
    }

    
}
