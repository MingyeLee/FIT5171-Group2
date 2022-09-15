package fit5171;

import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketTest {
    Ticket ticket;
    static Flight mockFlight;
    static FlightCollection mockFlightCollection;
    static Passenger mockPassenger;

    @BeforeAll
    static void initAll() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        mockFlightCollection = mock(FlightCollection.class);
        mockStatic(FlightCollection.class);
    }

    @BeforeEach
    void init() {
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
        ticket.setTicketStatus(true);
        assertEquals(1000 * 0.5 * 1.12, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testTicketPriceForOver60() {
        when(mockPassenger.getAge()).thenReturn(70);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(0, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testTicketPriceForBetween15And60() {
        when(mockPassenger.getAge()).thenReturn(50);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(1000 * 1.12, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testInvalidPriceAppliedToATicket() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Ticket(2345, -12, mockFlight, false, mockPassenger);
        });
        assertEquals("Ticket price must be non-negative number", e.getMessage());
    }

    @Test
    void testSetNullFlight() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setFlight(null);
        });
        assertEquals("Ticket flight cannot be null", e.getMessage());
    }


    @Test
    void testSetNullPassenger() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setPassenger(null);
        });
        assertEquals("Ticket passenger cannot be null", e.getMessage());
    }
}
