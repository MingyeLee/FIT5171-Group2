package fit5171;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static fit5171.FlightCollection.addFlights;
import static fit5171.FlightCollection.getFlightInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightCollectionTest {
    @Test
    void testAddFlights() {
//        Flight flight = new Flight();
//        flight = null;
        assertThrows(IllegalArgumentException.class, () -> {
            addFlights(null);
        });
    }

    @Test
    void testGetFlightInfo() {

        assertThrows(IllegalArgumentException.class, () -> {
            getFlightInfo(null, null);
        });
    }

    @Test
    void testGetFlightInfoTwo() {
        assertThrows(IllegalArgumentException.class, () -> {
            getFlightInfo(null);
        });
    }
}

//    @Test
//    void testGetFlightInfoThree() {
//        Flight flightObj = new Flight(1, "abc", "bca", "a", "b", Timestamp.valueOf("2022-12-04 00:00:00.0")
//                , Timestamp.valueOf("2022-12-05 00:00:00.0")
//                , new Airplane(1,"2",3,4,5));
//        ArrayList<Flight> flights = new ArrayList<>();
//        flights.add(flightObj);
//        FlightCollection.addFlights(flights);
//        assertEquals( 1,FlightCollection.getFlightInfo(1).getFlightID());
//
//    }
//    }






