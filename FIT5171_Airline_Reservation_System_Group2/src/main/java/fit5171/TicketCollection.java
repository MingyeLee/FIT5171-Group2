package fit5171;

import validation.TicketCollectionValidator;

import java.util.ArrayList;

public class TicketCollection {

    public static ArrayList<Ticket> tickets;

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public static void addTickets(ArrayList<Ticket> tickets_db) {
        //validate ticket_db is not null/empty/contains null/contains duplicate ticketID/contain ID already in existing tickets
        TicketCollectionValidator.validateTicketList(tickets_db, tickets);
        TicketCollection.tickets.addAll(tickets_db);
    }

    public static void getAllTickets() {
        //display all available tickets from the Ticket collection
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public static Ticket getTicketInfo(int ticket_id) {
        //SELECT a ticket where ticket id = ticket_id
        for (Ticket ticket : tickets) {
            if (ticket.getTicket_id() == ticket_id) {
                return ticket;
            }
        }
        return null;
    }


}
