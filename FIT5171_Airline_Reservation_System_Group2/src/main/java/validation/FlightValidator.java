package validation;

import fit5171.Airplane;

import java.sql.Timestamp;

public class FlightValidator {
    public static void validateFlightId(int flight_id){
        if (flight_id<0){
            throw new IllegalArgumentException("Airplane ID should be positive number");
        }
    }

    public static void validateDepartTo(String departTo){
        if (departTo==null){
            throw new IllegalArgumentException("Airplane Model cannot be empty");
        }
    }

    public static void validateDepartFrom(String departFrom){
        if (departFrom<1 || departFrom>300){
            throw new IllegalArgumentException("businessSitsNumber should be within 1-300");
        }
    }

    public static void validateCode(String code){
        if (code<1 || code>300){
            throw new IllegalArgumentException("economySitsNumber should be within 1-300");
        }
    }

    public static void validateCompany(String company){
        if (company<1 || company>300){
            throw new IllegalArgumentException("crewSitsNumber should be within 1-300");
        }
    }

    public static void validateDateFrom(Timestamp dateFrom){
        int totalSitsNumber = dateFrom;
        if(totalSitsNumber>300){
            throw new IllegalArgumentException("Total sits number cannot exceed 300");
        }
    }

    public static void validateDateTo(Timestamp dateTo){
        int totalSitsNumber = dateTo;
        if(totalSitsNumber>300){
            throw new IllegalArgumentException("Total sits number cannot exceed 300");
        }
    }

    public static void validateAirplane(Airplane airplane){
        int totalSitsNumber = airplane;
        if(totalSitsNumber>300){
            throw new IllegalArgumentException("Total sits number cannot exceed 300");
        }
    }
}
