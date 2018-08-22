public class Vehicle {


    private String vehicleRegNumber;
    private String vehicleMake;
    private String vehicleColour;

    public Vehicle(){}

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public String getVehicleMake(){
        return vehicleMake;
    }

    public String getVehicleColour(){
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Override
    public String toString(){
        return "Vehicle Information - | Registration Number: " +vehicleRegNumber+ " | Vehicle Colour: "+vehicleColour+ " | Vehicle Make:"+vehicleMake+" | ";
    }
}
