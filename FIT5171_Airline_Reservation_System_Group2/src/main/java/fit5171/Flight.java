package fit5171;

import validation.AirplaneValidator;
import validation.FlightValidator;

import java.sql.Timestamp;
import java.util.Calendar;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane; //need mock

    public Flight() {
    }

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom, Timestamp dateTo, Airplane airplane) {
        FlightValidator.validateFlightId(flight_id);
        FlightValidator.validateDepartTo(departTo);
        FlightValidator.validateDepartFrom(departFrom);
        FlightValidator.validateCode(code);
        FlightValidator.validateCompany(company);
        FlightValidator.validateDateFrom(dateFrom);
        FlightValidator.validateDateTo(dateTo, dateFrom);
        FlightValidator.validateAirplane(airplane);
        this.flightID = flight_id;
        this.departTo = departTo;
        this.departFrom = departFrom;
        this.code = code;
        this.company = company;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.airplane = airplane;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightId) {
        FlightValidator.validateFlightId(flightId);
        this.flightID = flightId;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        FlightValidator.validateDepartTo(departTo);
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        FlightValidator.validateDepartFrom(departFrom);
        this.departFrom = departFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        FlightValidator.validateCode(code);
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        FlightValidator.validateCompany(company);
        this.company = company;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        FlightValidator.validateDateFrom(dateFrom);
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        FlightValidator.validateDateTo(dateTo, dateFrom);
        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
//        FlightValidator.validateAirplane(airplane);
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString() {
        return "Flight{" + airplane.toString() +
                ", date to=" + getDateTo() + ", " + '\'' +
                ", date from='" + getDateFrom() + '\'' +
                ", depart from='" + getDepartFrom() + '\'' +
                ", depart to='" + getDepartTo() + '\'' +
                ", code=" + getCode() + '\'' +
                ", company=" + getCompany() + '\'' +
                ", code=" + getCode() + '\'' +
                '}';
    }
}
