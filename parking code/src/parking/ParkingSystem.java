package parking;


public class ParkingSystem {

    private Parking parkingLot;
    private  Totalincome income;
    private TotalNumberOfVehicle NumberOfVehicle;
    ParkingSystem(int[][] arr, int s) {

        parkingLot = new Parking(arr, s);
        income = Totalincome.getTotalIncome();
        NumberOfVehicle = new TotalNumberOfVehicle();
    }

    String parkIn(SelectConfiguration algo, String name, int year, int width, int len) {

        Vehicle vehicle = new Vehicle(name, year, width, len);

        Slot[] slots = parkingLot.getSlot();

        int index = algo.selectSlot(slots, vehicle.getWidth(),vehicle.getDepth());

        if (index == -1) {
            return null;
        } else
            return this.parkingLot.setSlot(index, vehicle);

    }

    Ticket parkOut(String id) {

        Vehicle vehicle = parkingLot.removeCar(id);

        if (vehicle == null)
            return null;


        Ticket ticket = vehicle.getTicket();

        ticket.setEndTime();

        int hours = ticket.totalHours();

        int COST = hours * 5;

        ticket.setPayAmount(COST);
        income.addCost_TotalIncome(COST);

        return ticket;
    }

    // function return total income
    public int TotalIncome(){return income.getIncome();}

    // function return all slots for display
    public Slot[] slot() {
        return parkingLot.getSlot();
    }

    // function return number of vehicle
    public int numberOfVehicles() {
        Slot[] slots = parkingLot.getSlot();
      int count = NumberOfVehicle.getnumberOfVehicles(slots);
        return count;
    }



}
