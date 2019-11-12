package model;

public class ParkingLot {
    private boolean isFull;

    public ParkingLot(boolean isFull) {
        this.isFull = isFull;
    }

    public Ticket park(Car car) throws Exception {
        if(!isFull) {
            return new Ticket(true);
        } else {
            throw new Exception("car park is full");
        }
    }

    public Car collectCar(Ticket ticket) {
        ticket.setValid(false);
        return new Car("123");
    }
}
