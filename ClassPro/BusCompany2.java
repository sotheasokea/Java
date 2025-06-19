import java.util.Scanner;

public class BusCompany2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String id = scan.next();
        int type = scan.nextInt();
        int seats = scan.nextInt();
        Bus2 b;
        b = new Bus2(id, type, seats);

        int N = scan.nextInt();
        for(int i = 0; i < N; ++i) {
            int P = scan.nextInt();
            int K = scan.nextInt();
            if(P == 1)
            b.reserve(K);
            else if(P == 2)
            b.sendToRepair();
            else if(P == 3)
            b.backToService();
            b.printStats();
        }
    }
}

class Bus2{
    String busCode;
    int busType; //1 for fan, 2 for air, 3 for special air
    int totalSeats;
    int reservedSeats;
    boolean busStatus;
    Bus2(String busCode, int busType, int totalSeatsSeats){
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
        if(!busStatus){
            return false;
        }
        if(this.reservedSeats + seats > this.totalSeats){
            return false;
        }
        this.reservedSeats += seats;
        return true;
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
