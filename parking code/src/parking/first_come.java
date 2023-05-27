package parking;


public class first_come implements SelectConfiguration {
    @Override
    public int selectSlot(Slot[]slot,int wid , int len){
        int size = slot.length;
        for (int i = 0;i < size;i++){
            if ((slot[i].getWidth() >= wid ) && (slot[i].getDepth() >= len ) && (slot[i].isEmpty())) {
                return i;
            }
        }
        return -1; // if no slot
    }
}
