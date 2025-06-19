import java.util.Scanner;

public class BusCompany {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfBus = input.nextInt();
        input.nextLine(); // Consume the newline after nextInt()

        String busCode;
        int busType;
        int totalSeats;
        Bus4[] bus = new Bus4[numOfBus];
        for (int i = 0; i < numOfBus; i++) {
            busCode = input.nextLine();
            busType = input.nextInt();
            totalSeats = input.nextInt();
            bus[i] = new Bus4(busCode, busType, totalSeats);
            input.nextLine(); // Consume the newline after nextInt()
        }

        int request = input.nextInt();
        int busNumber;
        int bookSeats;
        for (int i = 0; i < request; i++) {
            int checkBus = input.nextInt(); // 1 booking, 2-3 bus usable or unusable
            //int busNumber = input.nextInt(); // 1<= busNumber <= numOfBus

            if (checkBus == 1) {
                bookSeats = input.nextInt();
                int busTypeWanted = input.nextInt();
                boolean found = false;
                for(int k = 0; k<numOfBus; k++){
                    if(bus[k].reserve(bookSeats, busTypeWanted)){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("sorry");
                }
            } else if (checkBus == 2) {
                bookSeats = input.nextInt();
                busNumber = input.nextInt();
                bus[busNumber-1].sendToRepair();
            } else if (checkBus == 3) {
                bookSeats = input.nextInt();
                busNumber = input.nextInt();
                bus[busNumber-1].backToService();
            }
        }

        input.close();
    }
}
class Bus4{
    String busCode;
    int busType; //1 for fan, 2 for air, 3 for special air
    int totalSeats;
    int reservedSeats;
    boolean busStatus;
    Bus4(String busCode, int busType, int totalSeatsSeats){
        this.busCode = busCode;
        this.busType = busType;
        this.totalSeats = totalSeatsSeats;
        this.reservedSeats = 0;
        this.busStatus = true;
    }
    void sendToRepair(){
        busStatus = false;
    }
    void backToService(){
        busStatus = true;
    }
    boolean reserve(int seats){
        if(seats < 0)   seats = 0;
        if(!busStatus || this.reservedSeats + seats > this.totalSeats){
            return false;
        }
        this.reservedSeats += seats;
        return true;
    }
    boolean reserve(int Seats, int busType) {
        if(this.busType == busType && this.busStatus){
            if(Seats > 0 && this.reservedSeats +Seats <= totalSeats){
                this.reservedSeats += Seats;
                System.out.println(this.busCode);
                return true;
            }
        }
        return false;
    }
}
