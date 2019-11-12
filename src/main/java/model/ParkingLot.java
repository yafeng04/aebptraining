package model;

public class ParkingLot {
    private boolean isFull;

    public ParkingLot(boolean isFull) {
        this.isFull = isFull;
    }

    public Ticket park(Car car) throws Exception {
       if(!isFull) {
           return new Ticket();
       } else {
           throw new Exception("car park is full");
       }
    }
}
