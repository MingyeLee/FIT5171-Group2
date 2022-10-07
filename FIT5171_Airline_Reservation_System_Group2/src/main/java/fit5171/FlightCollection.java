package fit5171;

import validation.FlightCollectionValidator;

import java.util.ArrayList;

public class FlightCollection {

    public static ArrayList<Flight> flights;

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static void addFlights(ArrayList<Flight> flights) {
        if (flights == null || flights.contains(null)) {
            throw new IllegalArgumentException("Flight collection cannot be null or contain null value");
        }
        //	Appends all the elements in the specified collection to the end of this list,
        //	in the order that they are returned by the specified collection's Iterator.
        FlightCollection.flights.addAll(flights);
    }

    public static Flight getFlightInfo(String city1, String city2) {
        FlightCollectionValidator.validateCity(city1);
        FlightCollectionValidator.validateCity(city2);
        //display the flights where there is a direct flight from city 1 to city2
        return null;
    }

    public static Flight getFlightInfo(String city) {
        FlightCollectionValidator.validateCity(city);
        //SELECT a flight where depart_to = city
        return null;
    }

    public static Flight getFlightInfo(int flight_id) {
        //SELECT a flight with a particular flight id
        return flights.get(flight_id - 1);
    }


}
