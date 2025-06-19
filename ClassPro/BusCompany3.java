import java.util.Scanner;

public class BusCompany3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfBus = input.nextInt();
        input.nextLine(); // Consume the newline after nextInt()

        String busCode[] = new String[numOfBus];
        int busType[] = new int[numOfBus];
        int totalSeats[] = new int[numOfBus];
        
        for (int i = 0; i < numOfBus; i++) {
            busCode[i] = input.nextLine();
            busType[i] = input.nextInt();
            totalSeats[i] = input.nextInt();
            input.nextLine(); // Consume the newline after nextInt()
        }

        Bus3 bus = new Bus3(busCode, busType, totalSeats);
        int request = input.nextInt();
        int busNumber;
        int bookSeats;
        for (int i = 0; i < request; i++) {
            int checkBus = input.nextInt(); // 1 booking, 2-3 bus usable or unusable
            //int busNumber = input.nextInt(); // 1<= busNumber <= numOfBus

            if (checkBus == 1) {
                bookSeats = input.nextInt();
                int busTypeWanted = input.nextInt();
                bus.reserve(bookSeats,busTypeWanted);
            } else if (checkBus == 2) {
                bookSeats = input.nextInt();
                busNumber = input.nextInt();
                bus.sendToRepair(busNumber);
            } else if (checkBus == 3) {
                bookSeats = input.nextInt();
                busNumber = input.nextInt();
                bus.backToService(busNumber);
            }
        }

        input.close();
    }
}

class Bus3 {
    private String[] busCode;
    private int[] busType; // 1 for fan, 2 for air, 3 for special air
    private int[] totalSeats;
    private int[] reservedSeats;
    private boolean[] busStatus;

    Bus3(String[] busCode, int[] busType, int[] totalSeats) {
        this.busCode = busCode;
        this.busType = busType;
        this.totalSeats = totalSeats;
        int arrLength = busCode.length;
        this.reservedSeats = new int[arrLength];
        this.busStatus = new boolean[arrLength];

        for (int i = 0; i < arrLength; i++) {
            this.reservedSeats[i] = 0;
            this.busStatus[i] = true;
        }
    }

    void sendToRepair(int busNumber) {
        if (busNumber >= 1 && busNumber <= busCode.length) {
            busStatus[busNumber - 1] = false;
        }
    }

    void backToService(int busNumber) {
        if (busNumber >= 1 && busNumber <= busCode.length) {
            busStatus[busNumber - 1] = true;
        }
    }

    boolean reserve(int Seats, int busType) {
        for(int i = 0; i<busCode.length; i++){
            if(this.busType[i] == busType && this.busStatus[i]){
                if(Seats > 0 && this.reservedSeats[i]+Seats <= totalSeats[i]){
                    this.reservedSeats[i] += Seats;
                    System.out.println(this.busCode[i]);
                    return true;
                }
            }
        }
        System.out.println("sorry");
        return false;
    }
}
