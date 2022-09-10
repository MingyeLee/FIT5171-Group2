package fit5171;

import validation.AirplaneValidator;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {
        AirplaneValidator.validateAirplaneID(airplaneID);
        AirplaneValidator.validateAirplaneModel(airplaneModel);
        AirplaneValidator.validateBusinessSitsNumber(businessSitsNumber);
        AirplaneValidator.validateEconomySitsNumber(economySitsNumber);
        AirplaneValidator.validateCrewSitsNumber(crewSitsNumber);
        AirplaneValidator.validateTotalSitsNumber(businessSitsNumber,economySitsNumber,crewSitsNumber);
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        AirplaneValidator.validateAirplaneID(airplaneID);
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        AirplaneValidator.validateAirplaneModel(airplaneModel);
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        AirplaneValidator.validateBusinessSitsNumber(businessSitsNumber);
        AirplaneValidator.validateTotalSitsNumber(businessSitsNumber,this.economySitsNumber,this.crewSitsNumber);
        this.businessSitsNumber = businessSitsNumber;
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economySitsNumber) {
        AirplaneValidator.validateEconomySitsNumber(economySitsNumber);
        AirplaneValidator.validateTotalSitsNumber(this.businessSitsNumber,economySitsNumber,this.crewSitsNumber);
        this.economySitsNumber = economySitsNumber;
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        AirplaneValidator.validateCrewSitsNumber(crewSitsNumber);
        AirplaneValidator.validateTotalSitsNumber(this.businessSitsNumber,this.economySitsNumber,crewSitsNumber);
        this.crewSitsNumber = crewSitsNumber;
    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

	public static Airplane getAirPlaneInfo(int airplane_id) {
		// TODO Auto-generated method stub
		return null;
	}
}