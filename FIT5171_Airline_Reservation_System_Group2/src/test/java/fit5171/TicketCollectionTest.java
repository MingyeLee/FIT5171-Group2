package fit5171;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketCollectionTest {
    TicketCollection ticketCollection;
    Ticket existingTicket;


    @BeforeEach
    void init() {
        ticketCollection = new TicketCollection();
        ticketCollection.tickets = new ArrayList<>();
        existingTicket = mock(Ticket.class);
        when(existingTicket.getTicket_id()).thenReturn(1);
        ticketCollection.tickets.add(existingTicket);
    }

    @AfterEach
    void clean() {
        ticketCollection.tickets = new ArrayList<>();
    }

    @Test
    void addEmptyTicketList() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(new ArrayList<Ticket>());
        });
        assertEquals("Ticket list cannot be empty", e.getMessage());
    }

    @Test
    void addNullTicketList() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(null);
        });
        assertEquals("Ticket list cannot be empty", e.getMessage());
    }


    @Test
    void addValidTicketList() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(2);
        when(ticket1.getTicket_id()).thenReturn(3);
        tickets.add(ticket1);
        tickets.add(ticket2);
        ticketCollection.addTickets(tickets);
        assertEquals(ticketCollection.tickets, ticketCollection.getTickets());
    }

    @Test
    void addTicketListContainNull() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = null;
        Ticket ticket2 = mock(Ticket.class);
        when(ticket2.getTicket_id()).thenReturn(2);

        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket list cannot contain null", e.getMessage());
    }

    @Test
    void addTicketListContainDuplicatedID() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(2);
        when(ticket2.getTicket_id()).thenReturn(2);
        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket with ID:2 already exists", e.getMessage());
    }

    @Test
    void addTicketListContainExistingID() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(1);
        when(ticket2.getTicket_id()).thenReturn(2);
        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket with ID:1 already exists", e.getMessage());
    }

    @Test
    void testGetExistingTicket() {
        assertEquals(existingTicket, ticketCollection.getTicketInfo(1));
    }

    @Test
    void testGetNotExistingTicket() {
        assertNull(ticketCollection.getTicketInfo(2));
    }
}
