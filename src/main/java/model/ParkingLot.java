package model;

public class ParkingLot {
    private boolean isFull;

    public ParkingLot(boolean isFull) {
        this.isFull = isFull;
    }

    public Ticket park(Car car){
       if(!isFull) {
           return new Ticket();
       }
       return null;
    }
}
