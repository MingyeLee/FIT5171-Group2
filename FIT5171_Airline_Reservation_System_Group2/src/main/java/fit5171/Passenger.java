package fit5171;

import validation.PassengerValidator;

public class Passenger extends Person {
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger() {
    }

    public Passenger(String firstName, String secondName, int age, String gender, String email, String phoneNumber, String passport, String cardNumber, int securityCode) {
        super(firstName, secondName, age, gender);
        PassengerValidator.validateEmail(email);
        PassengerValidator.validatePhoneNumber(phoneNumber);
        PassengerValidator.validatePassportNumber(passport);
        PassengerValidator.validateCardNumber(cardNumber);
        PassengerValidator.validateCvcNumber(securityCode);
        this.securityCode = securityCode;
        this.cardNumber = cardNumber;
        this.passport = passport;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        PassengerValidator.validateEmail(email);
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        PassengerValidator.validatePassportNumber(passport);
        this.passport = passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PassengerValidator.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        PassengerValidator.validateCvcNumber(securityCode);
        this.securityCode = securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        PassengerValidator.validateCardNumber(cardNumber);
        this.cardNumber = cardNumber;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getSecondName() {
        return super.getSecondName();
    }

    @Override
    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public String toString() {
        return "Passenger{" + " Fullname= " + super.getFirstName() + " " + super.getSecondName() +
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}
