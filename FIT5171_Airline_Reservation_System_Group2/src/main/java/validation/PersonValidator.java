package validation;

public class PersonValidator {

    public static void validateGender(String gender) {
            if(!("male".equalsIgnoreCase(gender) || "female".equalsIgnoreCase(gender) || "other".equalsIgnoreCase(gender)))
                throw new IllegalArgumentException("Gender can only be Male Female or Other");
    }

    public static void validateName(String firstOrLastName) {
        try {
            if (!firstOrLastName.matches("[a-zA-Z]+"))
                throw new IllegalArgumentException("First/Last Name should only contain letters");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("First/second name or last name cannot be empty");
        }
    }

    public static void validateAge(int age) {
        if (age>=99 || age<=0)
            throw new IllegalArgumentException("Age can only be within 1-98");
    }

}
