package parking;

public class TotalNumberOfVehicle {
    // function return number of vehicle
    public int getnumberOfVehicles(Slot[] slots) {
        int size = slots.length, count = 0;
        for (int i = 0; i < size; i++) {
            if (slots[i].getVehicle() != null) {
                count++;
            }
        }
        return count;
    }

}
