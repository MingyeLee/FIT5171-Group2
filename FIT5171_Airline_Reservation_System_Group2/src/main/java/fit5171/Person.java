package fit5171;

import validation.PersonValidator;

public abstract class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String firstName, String secondName, int age, String gender) {
        PersonValidator.validateAge(age);
        PersonValidator.validateGender(gender);
        PersonValidator.validateName(firstName);
        PersonValidator.validateName(secondName);
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        PersonValidator.validateAge(age);
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        PersonValidator.validateGender(gender);
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        PersonValidator.validateName(firstName);
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        PersonValidator.validateName(secondName);
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
