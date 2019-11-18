package training;

import model.Car;
import model.ParkingBoy;
import model.ParkingLot;
import model.Ticket;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {
    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    @Test
    public void givenParkingLotIsNotFullWhenParkCarThenProvideTicket() throws Exception {
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        assert ticket != null;
    }

    @Test
    public void givenParkingLotIsNotFullWhenParkCarThenProvideAssociatedTicket() throws Exception {
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        assert ticket.getCarNumber().equals(car.getCarNumber());
    }

    @Test
    public void givenParkingLotIsFullWhenParkCarThenFailedToParkAndRemindCarParkIsFull() throws Exception {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        expectedException.expect(Exception.class);
        expectedException.expectMessage("car park is full");
        parkingLot.park(car);
    }

    @Test
    public void givenParkingLotIsNotFullWhenParkMultipleCarsThenProvideTickets() throws Exception {
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(2);
        Ticket ticket1 = parkingLot.park(car);
        Ticket ticket2 = parkingLot.park(car);
        assert ticket1!=null;
        assert ticket2!=null;
    }

    @Test
    public void givenValidTicketWhenCollectCarThenCollectedCarNumberEqualsParkingCarNumberAndTicketIsInvalid() throws Exception {
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

    @Test
    public void givenParkingBoyAndOneParkinglotWhenParkCarThenProvideTicket() throws Exception {
        List<ParkingLot> parkingLotList=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car("123");
        Ticket ticket = parkingBoy.park(car);
        assert ticket != null;

    }
    @Test
    public void givenParkingBoyAndEmptyParkinglot1AndEmptyParkinglot2WhenParkCarThenProvideTicketAndCarInParkinglot1() throws Exception {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        Car car = new Car("123");
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.park(car);
        assert ticket.getCarNumber().equals(car.getCarNumber());
        assert ticket.getParkingLot().equals(parkingLot1);
    }

}
