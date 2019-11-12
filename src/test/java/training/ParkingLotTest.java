package training;

import model.Car;
import model.ParkingLot;
import model.Ticket;
import org.junit.Test;

public class ParkingLotTest {
    // 停车
    @Test
    public void givenParkingLotIsNotFullWhenParkCarThenProvideTicket(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(false);
        Ticket ticket = parkingLot.park(car);
        assert ticket != null;
    }
}
