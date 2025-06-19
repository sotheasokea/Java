import java.util.Scanner;

public class BusCompany1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String id = scan.next();
        int type = scan.nextInt();
        int seats = scan.nextInt();
        Bus1 b = new Bus1(id, type, seats);
        b.printStats();
        scan.close();
    }
}

class Bus1{
    String busCode;
    int busType; //1 for fan, 2 for air, 3 for special air
    int totalSeats;
    int reservedSeats;
    boolean busStatus;
    Bus1(String busCode, int busType, int totalSeatsSeats){
        this.busCode = busCode;
        this.busType = busType;
        this.totalSeats = totalSeatsSeats;
        this.reservedSeats = 0;
        this.busStatus = true;
    }
    void printStats(){
        System.out.println(busCode);
        if(this.busType == 1){
            System.out.println("Fan");
        }else if(this.busType == 2){
            System.out.println("P1");
        }else if(this.busType == 3){
            System.out.println("VIP");
        }
        System.out.println(reservedSeats +" "+ totalSeats);
        if(busStatus){
            System.out.println("Active");
        }else{
            System.out.println("Inactive");
        }
    }
}
