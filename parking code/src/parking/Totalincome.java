package parking;

public class Totalincome {
    private int TotalIncome=0;

    private static Totalincome instance = null;
    private Totalincome(){}

    public int getIncome(){return  TotalIncome;}
    public void addCost_TotalIncome(int cost){TotalIncome+=cost;}
    public static Totalincome getTotalIncome(){
        if (instance == null){
            instance = new Totalincome();
        }
        return instance;
    }
}
