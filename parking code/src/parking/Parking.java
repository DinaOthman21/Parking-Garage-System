package parking;


public class Parking {

    private Slot[] slots;
    private int size;



    Parking(int[][] arr, int size) {
        this.size = size;
        slots = new Slot[size];
        String fixedName = "slot", name;

        for (int i = 0; i < size; i++) {
            name = fixedName + (i + 1);
            slots[i] = new Slot(arr[i][0], arr[i][1], name);
        }
    }

    public Slot[] getSlot() {
        return this.slots;
    }

    public String setSlot(int i, Vehicle vehicle) {
        String name = slots[i].getName();
        this.slots[i].setVehicle(vehicle);
        return name;
    }

    public Vehicle removeCar(String id) {

        int c = 0;
        int i;
        for ( i = 0; i < size; i++) {
            String ch = slots[i].getName();
            if (id.equals(ch) && slots[i].getVehicle() != null) {
                break;
            }
            c++;

        }
        if (c >= size)
            return null;

        Vehicle vehicle = slots[i].getVehicle();
        slots[i].reset();

        return vehicle;
    }


}
