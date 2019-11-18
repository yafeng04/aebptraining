package model;

public class Ticket {
    private String carNumber;

    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Ticket(String carNumber) {
        this.carNumber = carNumber;
    }

    public Ticket(String carNumber, ParkingLot parkingLot) {
        this.carNumber = carNumber;
        this.parkingLot = parkingLot;
    }

    public String getCarNumber() {
        return carNumber;
    }

}
