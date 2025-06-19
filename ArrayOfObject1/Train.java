
import java.util.ArrayList;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTrain = input.nextInt();
        ArrayList<Carriage> carriages = new ArrayList<>();
        for(int i = 0; i<numOfTrain; i++){
            int blockType = input.nextInt();
            int numSeat   = input.nextInt();
            int blockCode = input.nextInt();
            carriages.add(new Carriage(blockType, numSeat, blockCode));
        }
        int K = input.nextInt(); // number of request to book ticket
        // int[][] num_And_seat = new int[K][2];
        // int maxIndex = 1;
        for(int i = 0; i<K; i++){
            // num_And_seat[i][0] = input.nextInt();
            // num_And_seat[i][1] = input.nextInt();
            int trainNumber = input.nextInt();
            int numSeat = input.nextInt();
            carriages.get(trainNumber-1).reservedSeats(numSeat);
            // if(maxIndex < num_And_seat[i][0]){
            //     maxIndex = num_And_seat[i][0];
            // }
        }
        // System.out.println(maxIndex);
        // for(int m = 1; m<= maxIndex; m++){
            // for(int i = 0; i<K; i++){
            //     if(num_And_seat[i][0] == m){
            //         for(int r = 0; r<numOfTrain; r++){
            //             if(carriages.get(r).reservedSeats(num_And_seat[i][1])){
            //                 break;
            //             }
            //         }
            //     }
            // }
        // }
        for(int i = 0; i<numOfTrain; i++){
            carriages.get(i).printInfo();
        }
        input.close();
    }
}
class Carriage{
    int maxSeatCapacacity;
    int reservedSeat;
    int stand;
    int reservedStand;
    int blockType;
    int blockCode;
    Carriage(int blockType,int maxSeat, int blockCode){
        this.maxSeatCapacacity = maxSeat;
        this.reservedSeat = 0;
        this.blockType = blockType;
        this.blockCode = blockCode;
        if(blockType == 3){
            this.stand = 10;
        }else{
            this.stand = 0;
        }
    }
    void reservedSeats(int numSeat){
        if(reservedSeat + numSeat <= maxSeatCapacacity){
            reservedSeat += numSeat;
            // return  true;
        }else if(this.blockType == 3){
            int remainingSeat = (reservedSeat + numSeat) - maxSeatCapacacity;
            reservedSeat = maxSeatCapacacity;
            // if(reservedSeat < maxSeatCapacacity){
            //     numSeat = (reservedSeat+numSeat)-maxSeatCapacacity;
            //     reservedSeat = maxSeatCapacacity;
            // }
            if(remainingSeat > 0 && reservedStand + remainingSeat <= stand){
                reservedStand += remainingSeat;
                // return true;
            }
        }
        // return  false;
    }
    void printInfo(){
        if(blockType == 3){
            System.out.println(blockCode+" "+blockType+" "+reservedSeat+" "+maxSeatCapacacity+" "+reservedStand+" "+stand);
        }else{
            System.out.println(blockCode+" "+blockType+" "+reservedSeat+" "+maxSeatCapacacity);
        }
    }
}