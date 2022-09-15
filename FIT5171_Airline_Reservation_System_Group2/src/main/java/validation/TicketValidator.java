package validation;

import fit5171.Flight;
import fit5171.FlightCollection;
import fit5171.Passenger;

public class TicketValidator {
//    public static void validateStatus(boolean status) {
//        if (status != true && status != false) {
//            throw new IllegalArgumentException("Status must be true or false");
//        }
//    }

    public static void validateTicketPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ticket price must be non-negative number");
        }
    }

    public static void validateTicketFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Ticket flight cannot be null");
        }
    }

    public static void validateTicketPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Ticket passenger cannot be null");
        }
    }
}
