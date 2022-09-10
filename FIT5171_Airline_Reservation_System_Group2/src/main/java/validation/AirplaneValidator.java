package validation;

public class AirplaneValidator {
    public static void validateAirplaneID(int airplaneID){
        if (airplaneID<0){
            throw new IllegalArgumentException("Airplane ID should be positive number");
        }
    }

    public static void validateAirplaneModel(String airplaneModel){
        if (airplaneModel==null){
            throw new IllegalArgumentException("Airplane Model cannot be empty");
        }
    }

    public static void validateBusinessSitsNumber(int businessSitsNumber){
        if (businessSitsNumber<1 || businessSitsNumber>300){
            throw new IllegalArgumentException("businessSitsNumber should be within 1-300");
        }
    }

    public static void validateEconomySitsNumber(int economySitsNumber){
        if (economySitsNumber<1 || economySitsNumber>300){
            throw new IllegalArgumentException("economySitsNumber should be within 1-300");
        }
    }

    public static void validateCrewSitsNumber(int crewSitsNumber){
        if (crewSitsNumber<1 || crewSitsNumber>300){
            throw new IllegalArgumentException("crewSitsNumber should be within 1-300");
        }
    }

    public static void validateTotalSitsNumber(int businessSitsNumber, int economySitsNumber,int crewSitsNumber){
        int totalSitsNumber = businessSitsNumber+economySitsNumber+crewSitsNumber;
        if(totalSitsNumber>300){
            throw new IllegalArgumentException("Total sits number cannot exceed 300");
        }
    }
}
