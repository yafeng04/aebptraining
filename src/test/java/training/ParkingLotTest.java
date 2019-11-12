package training;

import model.Car;
import model.ParkingLot;
import model.Ticket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {
    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    @Test
    public void givenParkingLotIsNotFullWhenParkCarThenProvideTicket() throws Exception {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        assert ticket != null;
    }

    @Test
    public void givenParkingLotIsFullWhenParkCarThenFailedToParkAndRemindCarParkIsFull() throws Exception {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        expectedException.expect(Exception.class);
        expectedException.expectMessage("car park is full");
        parkingLot.park(car);
    }

    @Test
    public void givenValidTicketWhenCollectCarThenTicketIsInvalidAndCollectedCarNumberEqualsParkingCarNumber() throws Exception {
        Car newCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(newCar);
        Car collectedCar = parkingLot.collectCar(ticket);
        assert collectedCar.getCarNumber().equals(newCar.getCarNumber());
        expectedException.expect(Exception.class);
        expectedException.expectMessage("invalid ticket");
        parkingLot.collectCar(ticket);
    }

    @Test
    public void givenInvalidTicketWhenCollectCarThenFailedToCollectAndRemindInvalidTicket() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("invalid ticket");

        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = new Ticket("123");
        parkingLot.collectCar(ticket);
    }
}
