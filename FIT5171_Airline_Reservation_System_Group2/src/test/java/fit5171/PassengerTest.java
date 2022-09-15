package fit5171;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("A passenger test class")
public class PassengerTest {
    private Passenger passenger;

    @BeforeAll
    static void initAll() {

    }

    @BeforeEach
    void init() {
        passenger = new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
    }

    @Test
    void testCreateValidFemalePassenger() {
        assertNotNull(new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908));
    }

    @Test
    void testCreateValidMalePassenger() {
        assertNotNull(new Passenger("John", "Doe", 22, "Male", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908));
    }

    @Test
    void testCreateValidOtherGenderPassenger() {
        assertNotNull(new Passenger("Jane", "Doe", 22, "Other", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908));
    }

    @Test
    void testCreatePassengerWithInvalidGender() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Jane", "Doe", 22, "xxx", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Gender can only be Male Female or Other", e.getMessage());
    }

    @Test
    void testCreateValidNullGenderPassenger() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Jane", "Doe", 22, null, "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Gender can only be Male Female or Other", e.getMessage());
    }

    @Test
    void testNullFirstNameInConstructor() {

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger(null, "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("First/second name or last name cannot be empty", e.getMessage());
    }

    @Test
    void testNullSecondNameInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", null, 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("First/second name or last name cannot be empty", e.getMessage());
    }

    @Test
    void testNegativeAgeInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", -10, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Age can only be within 1-98", e.getMessage());
    }

    @Test
    void testNullGenderInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, null, "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Gender can only be Male Female or Other", e.getMessage());
    }


    @Test
    void testNullEmailInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, "Male", null, "0488256354", "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Email address cannot be empty", e.getMessage());
    }

    @Test
    void testNullPhoneNumberInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, "Male", "abd@domain.com", null, "AB8976754", "5674635271624728", 908);
        });
        assertEquals("Phone number cannot be empty", e.getMessage());
    }

    @Test
    void testNullCardNumberInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, "Male", "abd@domain.com", "0488256354", "AB8976754", null, 908);
        });
        assertEquals("Card number cannot be empty", e.getMessage());
    }

    @Test
    void testNullPassportNumberInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, "Male", "abd@domain.com", "0488256354", null, "5674635271624728", 908);
        });
        assertEquals("Passport number cannot be empty", e.getMessage());
    }

    @Test
    void testInvalidSecurityCodeInConstructor() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger = new Passenger("Jane", "Doe", 30, "Male", "abd@domain.com", "0488256354", "AB8976754", "5674635271624728", 90008);
        });
        assertEquals("Invalid cvc number:Cvc number should be 3 digits", e.getMessage());
    }


    @Test
    void testSetValidPhoneNumberStartsWith05() {
        String phone = "0512345678";
        String expectedResult = "0512345678";
        passenger.setPhoneNumber(phone);
        assertEquals(expectedResult, passenger.getPhoneNumber());
    }

    @Test
    void testSetValidPhoneNumberStartsWith04() {
        String phone = "0412345678";
        String expectedResult = "0412345678";
        passenger.setPhoneNumber(phone);
        assertEquals(expectedResult, passenger.getPhoneNumber());
    }

    @Test
    void testSetValidPhoneNumberStartsWith61() {
        String phone = "6112345678";
        String expectedResult = "6112345678";
        passenger.setPhoneNumber(phone);
        assertEquals(expectedResult, passenger.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumberLengthExceed9() {
        String phone = "6112345678000";
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber(phone);
        });
        assertEquals("Invalid phone number:phone number should starts with 04/05/61 with length 9", e.getMessage());
    }

    @Test
    void testSetPhoneNumberContainsLetter() {
        String phone = "qwe1213ec";
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber(phone);
        });
        assertEquals("Invalid phone number:phone number should starts with 04/05/61 with length 9", e.getMessage());
    }

    @Test
    void testValidEmail() {
        String email = "xyz@abcde.com";
        String expectedResult = "xyz@abcde.com";
        passenger.setEmail(email);
        assertEquals(expectedResult, passenger.getEmail());
    }

    @Test
    void testInvalidEmail() {
        String email = "xyz@abcdecom";
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setEmail(email);
        });
        assertEquals("Invalid Email address:username and domain can only be letters and must end with .com", e.getMessage());
    }

    @Test
    void testValidPassport() {
        String passport = "ex0989078";
        String expectedResult = "ex0989078";
        passenger.setPassport(passport);
        assertEquals(expectedResult, passenger.getPassport());
    }

    @Test
    void testPassportNumberMoreThan9Characters() {
        String passport = "ex0989078099";
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPassport(passport);
        });
        assertEquals("Invalid passport number:passport number must contain 9 characters", e.getMessage());
    }

    @Test
    void testValidCardNumber() {
        String cardNumber = "1234234565434567";
        String expectedResult = "1234234565434567";
        passenger.setCardNumber(cardNumber);
        assertEquals(expectedResult, passenger.getCardNumber());
    }

    @Test
    void testInvalidCardNumber() {
        String cardNumber = "9ascece12e";
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setCardNumber(cardNumber);
        });
        assertEquals("Invalid card number:Card number should be 16 digits", e.getMessage());
    }

    @Test
    void testValidCvcNumber() {
        int cvc = 198;
        int expectedResult = 198;
        passenger.setSecurityCode(cvc);
        assertEquals(expectedResult, passenger.getSecurityCode());
    }

    @Test
    @DisplayName("Test cvc contains 4 digits")
    void testInvalidCvcNumber() {
        int cvc = 1234;
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setSecurityCode(cvc);
        });
        assertEquals("Invalid cvc number:Cvc number should be 3 digits", e.getMessage());
    }
}
