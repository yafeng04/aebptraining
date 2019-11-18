package model;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;

    }

    public Ticket park(Car car) throws Exception {
        for(ParkingLot parkingLot:parkingLotList){
            if(parkingLot.getCarList().size()<parkingLot.getCarSpace()){
                return parkingLot.park(car);
            }
        }
        throw new Exception("all car parks is full");

    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}
