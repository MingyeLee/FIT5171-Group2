package fit5171;

import validation.PassengerValidator;
import validation.PersonValidator;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class BuyTicket<T> {
    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner in = new Scanner(System.in);

    public BuyTicket() {
        passenger = new Passenger();
        ticket = new Ticket();
        flight = new Flight();
    }

    public BuyTicket(Passenger passenger, Flight flight, Ticket ticket) {
        this.passenger = passenger;
        this.ticket = ticket;
        this.flight = flight;
    }

    public boolean showTicket() {
        try {
            System.out.println("You have bought a ticket for flight " + ticket.getFlight().getDepartFrom() + " - " + ticket.getFlight().getDepartTo() + "\n\nDetails:");
            System.out.println(this.ticket.toString());
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void buyTicket(int ticket_id) throws Exception
    //method for buying one ticket with direct flight
    {
        int flight_id;

        //select ticket where ticket_id="+ticket_id"
        // TODO: 13/09/2022  
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        //if there is a valid ticket id was input then we buy it, otherwise show message
        if (validTicket == null) {
            System.out.println("This ticket does not exist.");
            return;
        } else if (validTicket.ticketStatus()) {
            System.out.println("Sorry, ticket has been booked.");
            return;
        } else {
            //select flight_id from ticket where ticket_id=" + ticket_id
            flight_id = validTicket.getFlight().getFlightID();
            try {
                //FirstName

                System.out.println("Enter your First Name: ");
                String firstName = in.nextLine();
                PersonValidator.validateName(firstName);
                passenger.setFirstName(firstName);


                //SecondName

                System.out.println("Enter your Second name:");
                String secondName = in.nextLine();
                PersonValidator.validateName(secondName);
                passenger.setSecondName(secondName); //setting passengers info


                //Age

                System.out.println("Enter your age:");
                Integer age = in.nextInt();
                in.nextLine();
                PersonValidator.validateAge(age);
                passenger.setAge(age);


                //Gender

                System.out.println("Enter your gender: ");
                String gender = in.nextLine();
                PersonValidator.validateGender(gender);
                passenger.setGender(gender);


                //Email

                System.out.println("Enter your e-mail address");
                String email = in.nextLine();
                PassengerValidator.validateEmail(email);
                passenger.setEmail(email);


                //Phone Number

                System.out.println("Enter your phone number (start with 04/05/61):");
                String phoneNumber = in.nextLine();
                PassengerValidator.validatePhoneNumber(phoneNumber);
                passenger.setPhoneNumber(phoneNumber);


                //Passport

                System.out.println("Enter your passport number:");
                String passportNumber = in.nextLine();
                PassengerValidator.validatePassportNumber(passportNumber);
                passenger.setPassport(passportNumber);


                //Purchase or not
                int purch;

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                purch = in.nextInt();
                in.nextLine();


                if (purch == 0) { //Not purchase
                    return;
                } else { //Purchase
                    flight = FlightCollection.getFlightInfo(flight_id);
                    // TODO: if null ...........

                    int airplane_id = flight.getAirplane().getAirplaneID();

                    //TODO need mock
                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                    ticket = TicketCollection.getTicketInfo(ticket_id);

                    ticket.setPassenger(passenger);
                    ticket.setTicket_id(ticket_id);
                    ticket.setFlight(flight);
                    ticket.setPrice(ticket.getPrice());
                    ticket.setClassVip(ticket.getClassVip());
                    ticket.setTicketStatus(true);
                    if (ticket.getClassVip() == true) {
                        airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                    } else {
                        airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                    }

                }
                System.out.println("Your bill: " + ticket.getPrice() + "\n");
                //Card number

                System.out.println("Enter your card number:");
                String cardNumber = in.nextLine();
                PassengerValidator.validateCardNumber(cardNumber);
                passenger.setCardNumber(cardNumber);


                //Cvc code

                System.out.println("Enter your security code:");
                Integer securityCode = in.nextInt();
                PassengerValidator.validateCvcNumber(securityCode);
                passenger.setSecurityCode(securityCode);


            } catch (PatternSyntaxException patternException) {
                patternException.printStackTrace();
            }
        }
    }

    @SuppressWarnings("null")
    public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception {
        //method for buying two tickets with transfer flight
        int flight_id_first;
        int flight_id_second;

        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticket_id_first);
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_first);


        System.out.println("Processing...");

        //if there is a valid ticket id was input then we buy it, otherwise show message
        if (validTicketFirst != null || validTicketSecond != null) {
            System.out.println("This ticket does not exist.");
            return;
        } else if (validTicketFirst.ticketStatus()) {
            System.out.println("Sorry,ticket 1 has been booked.");
            return;
        } else if (validTicketSecond.ticketStatus()) {
            System.out.println("Sorry, ticket 2 has been booked.");
            return;
        } else {
            flight_id_first = validTicketFirst.getFlight().getFlightID();
            flight_id_second = validTicketFirst.getFlight().getFlightID();

            try {
                //FirstName
                while (true) {
                    try {
                        System.out.println("Enter your First Name: ");
                        String firstName = in.nextLine();
                        PersonValidator.validateName(firstName);
                        passenger.setFirstName(firstName);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //SecondName
                while (true) {
                    try {
                        System.out.println("Enter your Second name:");
                        String secondName = in.nextLine();
                        PersonValidator.validateName(secondName);
                        passenger.setSecondName(secondName); //setting passengers info
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Age
                while (true) {
                    try {
                        System.out.println("Enter your age:");
                        Integer age = in.nextInt();
                        in.nextLine();
                        PersonValidator.validateAge(age);
                        passenger.setAge(age);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Gender
                while (true) {
                    try {
                        System.out.println("Enter your gender: ");
                        String gender = in.nextLine();
                        PersonValidator.validateGender(gender);
                        passenger.setGender(gender);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Email
                while (true) {
                    try {
                        System.out.println("Enter your e-mail address");
                        String email = in.nextLine();
                        PassengerValidator.validateEmail(email);
                        passenger.setEmail(email);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Phone Number
                while (true) {
                    try {
                        System.out.println("Enter your phone number (start with 04/05/61):");
                        String phoneNumber = in.nextLine();
                        PassengerValidator.validatePhoneNumber(phoneNumber);
                        passenger.setPhoneNumber(phoneNumber);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Passport
                while (true) {
                    try {
                        System.out.println("Enter your passport number:");
                        String passportNumber = in.nextLine();
                        PassengerValidator.validatePassportNumber(passportNumber);
                        passenger.setPassport(passportNumber);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Purchase or not
                int purch;
                while (true) {
                    System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                    purch = in.nextInt();
                    in.nextLine();
                    if (purch == 1 || purch == 0)
                        break;
                }

                if (purch == 0) { //not purchase
                    return;
                } else { //purchase

                    //  "select * from flight, airplane where flight_id=" + flight_id_first + " and flight.airplane_id=airplane.airplane_id");
                    Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);
                    // TODO: null.......

                    int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);


                    Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);
                    // TODO: null .......

                    int airplane_id_second = flight_second.getAirplane().getAirplaneID();
                    Airplane airplane_second = Airplane.getAirPlaneInfo(airplane_id_second);


                    Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);
                    Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);

                    ticket_first.setPassenger(passenger);
                    ticket_first.setTicket_id(ticket_id_first);
                    ticket_first.setFlight(flight_first);
                    ticket_first.setPrice(ticket_first.getPrice());
                    ticket_first.setClassVip(ticket_first.getClassVip());
                    ticket_first.setTicketStatus(true);

                    if (ticket_first.getClassVip() == true) {
                        airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                    } else {
                        airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket_second.setPassenger(passenger);
                    ticket_second.setTicket_id(ticket_id_second);
                    ticket_second.setFlight(flight_first);
                    ticket_second.setPrice(ticket_second.getPrice());
                    ticket_second.setClassVip(ticket_second.getClassVip());
                    ticket_second.setTicketStatus(true);
                    if (ticket_second.getClassVip() == true) {
                        airplane_second.setBusinessSitsNumber(airplane_second.getBusinessSitsNumber() - 1);
                    } else {
                        airplane_second.setEconomySitsNumber(airplane_second.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());

                    System.out.println("Your bill: " + ticket.getPrice() + "\n");

                    //Card number
                    while (true) {
                        try {
                            System.out.println("Enter your card number:");
                            String cardNumber = in.nextLine();
                            PassengerValidator.validateCardNumber(cardNumber);
                            passenger.setCardNumber(cardNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                        }
                    }

                    //Cvc code
                    while (true) {
                        try {
                            System.out.println("Enter your security code:");
                            Integer securityCode = in.nextInt();
                            PassengerValidator.validateCvcNumber(securityCode);
                            passenger.setSecurityCode(securityCode);
                            break;
                        } catch (IllegalArgumentException e) {
                        }
                    }

                }
            } catch (PatternSyntaxException patternException) {
                patternException.printStackTrace();
            }
        }

    }

}
