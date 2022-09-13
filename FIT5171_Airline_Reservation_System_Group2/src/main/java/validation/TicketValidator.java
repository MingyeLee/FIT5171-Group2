package validation;

public class TicketValidator {
    public static void validateStatus(boolean status) {
        if (status != true && status != false) {
            throw new IllegalArgumentException("Status must be true or false");
        }
    }

    public static void validTicketPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ticket price must be non-negative number");
        }
    }
}
