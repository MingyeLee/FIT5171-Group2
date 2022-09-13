package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketTest {
    private Ticket ticket;
    private Flight mockFlight;
    private Passenger mockPassenger;

    @BeforeEach
    void initAll() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        ticket = new Ticket(2345, 123, mockFlight, false, mockPassenger);
    }

    @Test
    void testTicketStatusTrue() {
        boolean status = true;
        boolean expectedResult = true;
        ticket.setTicketStatus(status);
        assertEquals(expectedResult, ticket.ticketStatus());
    }

    @Test
    void testTicketStatusFalse() {
        boolean status = false;
        boolean expectedResult = false;
        ticket.setTicketStatus(status);
        assertEquals(expectedResult, ticket.ticketStatus());
    }

    @Test
    void testTicketPriceForUnder15() {
        when(mockPassenger.getAge()).thenReturn(10);
        ticket.setPrice(1000);

        assertEquals(500 * 1.12, ticket.getPrice());
    }

    @Test
    void testTicketPriceForOver60() {
        when(mockPassenger.getAge()).thenReturn(70);
        ticket.setPrice(1000);
        assertEquals(0, ticket.getPrice());
    }

    @Test
    void testTicketPriceForBetween15And60() {
        when(mockPassenger.getAge()).thenReturn(50);
        ticket.setPrice(1000);
        assertEquals(1000 * 1.12, ticket.getPrice());
    }

    @Test
    void testInvalidPriceAppliedToATicket() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Ticket(2345, -12, mockFlight, false, mockPassenger);
        });
        assertEquals("Ticket price must be non-negative number", e.getMessage());
    }


}
