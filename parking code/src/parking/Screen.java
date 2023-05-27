package parking;

import java.util.Scanner;

public class Screen {

    public ParkingSystem Garage;

    public void viewSlots(Slot[] slots){
        int size = slots.length;
        for (int i =0;i < size;i++){
            boolean free = slots[i].isEmpty();
            if (free)
            {
                System.out.println(slots[i].getName() + "  (Slot is Free)\n");
            }
            else {
                System.out.println(slots[i].getName() + "  (Slot is not Free)\n");
            }

        }
  }

    public static void viewTicket( Ticket ticket) {

        System.out.println("\n-----------------------    Ticket  -----------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.print("|     From: ");
        System.out.print(ticket.getStartTime());
        System.out.print("      to: ");
        System.out.println(ticket.getEndTime());
        System.out.println("|     Total Hours: " + ticket.totalHours() + "\n");
        System.out.println("|     Total cost: " + ticket.getPayAmount() + " EGP");
        System.out.println("-----------------------------------------------------------------\n");
    }

    public  static  void displayTotalVehicle(int number){
        System.out.println("Total number of vehicle: " + number);
    }

    public  static  void displayTotalIncome(int number){
        System.out.println("Total income: " + number);
    }



    public static void main(String[] args) {
        Screen screen = new Screen();
        Scanner input = new Scanner(System.in);

        int size;

        ////////////// TAKE NUMBER OF SLOT FROM GARAGE OWNER
        System.out.print("Enter number of slots: ");
        int numberOfSlots = input.nextInt();
        size = numberOfSlots;

        ////////////// TAKE DIMENSIONS FROM GARAGE OWNER
        System.out.println("Input dimensions.");

        int inputWidth, inputDepth;
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
                System.out.print("Enter width of slot " + (i + 1) + ":");

                inputWidth = input.nextInt();

                System.out.print("Enter depth of slot " + (i + 1) + ":");
                inputDepth  = input.nextInt();


            arr[i][0] = inputWidth;
            arr[i][1] = inputDepth;
        }
        ///////////////////////////////////////////

        ////// CREATE GARAGE
        screen.Garage = new ParkingSystem(arr, size);

        //////////// SELECT CONFIGURATION OF PARK IN
        System.out.println("           1- First Come.");
        System.out.println("           2- Best Fit.");
        System.out.print("choice: ");
        int select;
        select = input.nextInt();
        SelectConfiguration selectt;
        if (select==1)
        {
         selectt = new first_come();
        }else{
            selectt = new Best_fit();
        }
        /////////////////////////////////////////////

      while (true){
          System.out.println("******************************************************");
          System.out.println("*           1- Garage owner.                         *");
          System.out.println("*           2- Car owner.                            *");
          System.out.println("*           3- Exit.                                 *");
          System.out.println("****************************************************\n");
          int ch;
          System.out.print("choice: ");
          ch = input.nextInt();

          if(ch == 1){
              while (true) {

                  System.out.println("****************************************************");
                  System.out.println("*           1- View slots.                         *");
                  System.out.println("*           2- Total number of vehicles.           *");
                  System.out.println("*           3- Total income.                       *");
                  System.out.println("*           4- Exit                                *");
                  System.out.println("****************************************************\n");


                  int ch1;
                  System.out.print("choice: ");
                  ch1 = input.nextInt();

                  if (ch1 == 1) {

                      screen.viewSlots(screen.Garage.slot());

                  } else if (ch1 == 2) {

                      screen.displayTotalVehicle(screen.Garage.numberOfVehicles());

                  } else if (ch1 == 3) {
                      screen.displayTotalIncome(screen.Garage.TotalIncome());

                  } else if (ch1 == 4) {
                      break;
                  }
              }
          }else if (ch == 2){
              while (true){

                  System.out.println("****************************************************");
                  System.out.println("*           1- park in.                            *");
                  System.out.println("*           2- park out.                           *");
                  System.out.println("*           3- Exit.                               *");
                  System.out.println("****************************************************\n");

                  int ch2;
                  System.out.print("choice: ");
                  ch2 = input.nextInt();

                  if (ch2 == 1) {
                      String modelName, modelYear, width, length;
                      int wi, len, year;

                      while (true) {
                          Scanner homeScan = new Scanner(System.in);

                          try {

                              System.out.print("Enter model name: ");
                              modelName = homeScan.nextLine();

                              System.out.print("Enter model year: ");
                              modelYear = homeScan.nextLine();

                              System.out.print("Enter width of car: ");
                              width = homeScan.nextLine();

                              System.out.print("Enter depth of car: ");

                              length = homeScan.nextLine();
                              year = Integer.parseInt(modelYear);
                              wi = Integer.parseInt(width);
                              len = Integer.parseInt(length);
                              break;
                          } catch (NumberFormatException e) {
                              System.out.print("\ninvalid data ");
                              System.out.println(e.getMessage());
                              System.out.println("please Enter data like (kia - 2002 - 120 - 200)\n");
                          }
                      }


                      String id = screen.Garage.parkIn(selectt, modelName, year, wi, len);

                      if (id == null) {
                          System.out.println("\nNo valid slot for your car\n");
                      } else if (id.equals("f")) {
                          System.out.println("\nNo empty slots in garage\n");
                      } else {
                          System.out.println("\npark in successfully, your id: " + id + "\n");
                      }

                  } else if (ch2 == 2) {
                      Scanner homeScan = new Scanner(System.in);
                      System.out.print("Enter id:");

                      String id;

                      id = homeScan.nextLine();

                      screen.viewTicket(screen.Garage.parkOut(id));

                  }
                  else if (ch2 == 3){
                      break;
                  }
              }
          }
          else if (ch == 3){
              break;
          }

      }






    }
}
