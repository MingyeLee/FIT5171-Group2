package validation;

import fit5171.Ticket;

import java.util.ArrayList;

public class TicketCollectionValidator {
    public static void validateTicketList(ArrayList<Ticket> newTickets, ArrayList<Ticket> existingTickets) {
        if (newTickets == null || newTickets.isEmpty())
            throw new IllegalArgumentException("Ticket list cannot be empty");
        ArrayList<Integer> newTicketIDs = new ArrayList<Integer>();
        for (Ticket newTicket :
                newTickets
        ) {
            if (newTicket == null)
                throw new IllegalArgumentException("Ticket list cannot contain null");
            else {
                if (newTicketIDs.contains(newTicket.getTicket_id()))
                    throw new IllegalArgumentException("Ticket with ID:" + newTicket.getTicket_id() + " already exists");
                newTicketIDs.add(newTicket.getTicket_id());

                for (Ticket existingTicket : existingTickets
                ) {
                    if (newTicket.getTicket_id() == existingTicket.getTicket_id())
                        throw new IllegalArgumentException("Ticket with ID:" + newTicket.getTicket_id() + " already exists");
                }

            }
        }
    }
}
