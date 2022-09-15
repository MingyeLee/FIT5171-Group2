package validation;

import fit5171.Airplane;

import java.sql.Timestamp;

public class FlightValidator {
    public static void validateFlightId(int flight_id) {
        if (flight_id <= 0) {
            throw new IllegalArgumentException("Flight ID should be positive number");
        }
    }

    public static void validateDepartTo(String departTo) {
        if (departTo == null) {
            throw new IllegalArgumentException("the Depart to destination cannot be empty");
        }
    }

    public static void validateDepartFrom(String departFrom) {
        if (departFrom == null) {
            throw new IllegalArgumentException("the Depart from place cannot be empty");
        }

    }

    public static void validateCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("the code cannot be empty");
        }
    }

    public static void validateCompany(String company) {
        if (company == null) {
            throw new IllegalArgumentException("the company cannot be empty");
        }
    }

    public static void validateDateFrom(Timestamp dateFrom) {
        if (dateFrom == null)
            throw new IllegalArgumentException("Date from cannot be null");
        if (dateFrom.before(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Date from cannot before current time");
        }
    }

    public static void validateDateTo(Timestamp dateTo, Timestamp dateFrom) {
        if (dateTo.before(new Timestamp(System.currentTimeMillis())) || dateTo.before(dateFrom)) {
            throw new IllegalArgumentException("Date from cannot before current time or Date from");
        }
    }

    public static void validateAirplane(Airplane airplane) {
        if (airplane == null) {
            throw new IllegalArgumentException("airplane cannot be empty");
        }
    }
}
