package validation;

public class PassengerValidator {

    public static void validatePhoneNumber(String phoneNumber) {
        try {
            if (!phoneNumber.matches("04\\d{8}|05\\d{8}|61\\d{8}"))
                throw new IllegalArgumentException("Invalid phone number:phone number should starts with 04/05/61 with length 9");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
    }

    public static void validateEmail(String email) {
        try {
            if (!email.matches("^[a-zA-Z]+@[a-zA-Z]+\\.com$"))
                throw new IllegalArgumentException("Invalid Email address:username and domain can only be letters and must end with .com");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Email address cannot be empty");
        }
    }

    public static void validatePassportNumber(String passportNumber) {
        try {
            if (!passportNumber.matches("^[a-zA-Z0-9]{9}$"))
                throw new IllegalArgumentException("Invalid passport number:passport number must contain 9 characters");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Passport number cannot be empty");
        }
    }

    public static void validateCardNumber(String cardNumber) {
        try {
            if (!cardNumber.matches("^\\d{16}$"))
                throw new IllegalArgumentException("Invalid card number:Card number should be 16 digits");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Card number cannot be empty");
        }
    }

    public static void validateCvcNumber(int cvcNumber) {

        if (cvcNumber < 100 || cvcNumber > 999) {
            throw new IllegalArgumentException("Invalid cvc number:Cvc number should be 3 digits");
        }
    }
}
