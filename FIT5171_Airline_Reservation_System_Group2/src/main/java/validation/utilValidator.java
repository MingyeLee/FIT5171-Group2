package validation;

//TODO sample test class for Ticket(Collection) and Flight(Collection)
public class utilValidator {
    public static void validateCity(String cityName) {
        try {
            if (!cityName.matches("^[a-zA-Z\\s]+$"))
                throw new IllegalArgumentException("Invalid city name:City name can only contain letter and space");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("City cannot be empty");
        }
    }
}
