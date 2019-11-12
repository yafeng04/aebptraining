package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private int carSpace;

    private List<Car> carList = new ArrayList<Car>();

    public ParkingLot(int carSpace) {
        this.carSpace = carSpace;
    }

    public Ticket park(Car car) throws Exception {
        if (carList.size() < carSpace) {
            carList.add(car);
            return new Ticket(car.getCarNumber());
        } else {
            throw new Exception("car park is full");
        }
    }

    public Car collectCar(Ticket ticket) throws Exception {
        Optional<Car> carOptional = carList.stream().filter(x -> x.getCarNumber().equals(ticket.getCarNumber())).findFirst();
        if (!carOptional.isPresent()) {
            throw new Exception("invalid ticket");
        }
        carList.remove(carOptional.get());
        return carOptional.get();
    }
}
