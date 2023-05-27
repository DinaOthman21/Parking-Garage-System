package parking;

public class Best_fit implements SelectConfiguration {
    @Override
   public int selectSlot(Slot[]slot,int wid,int len){
        int size = slot.length;
        int minWidth = 1000, minDepth  = 1000, minI = -1;

        for (int i = 0;i < size;i++){
            if ((slot[i].isEmpty()) && slot[i].getWidth() >= wid && slot[i].getDepth() >= len){
                if ( slot[i].getWidth() == wid && slot[i].getDepth() == len ){
                    return  i;
                }
                else if (slot[i].getWidth() >= wid  && slot[i].getDepth() >= len ){
                    if(minWidth > slot[i].getWidth() && minDepth > slot[i].getDepth()) {
                        minWidth = slot[i].getWidth();
                        minDepth = slot[i].getDepth();
                        minI = i;

                    }

                }

                if(i==size-1){
                    return minI;
                }
            }


        }
        return -1;// if no slot
    }
}
