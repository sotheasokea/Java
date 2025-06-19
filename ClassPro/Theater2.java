
import java.util.Scanner;

public class Theater2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int threeD1 = scan.nextInt();
        int luxury1 = scan.nextInt();
        int numSeats = scan.nextInt();
        boolean threeD = false;
        boolean luxury = false;
        if(threeD1 == 1)
        threeD = true;
        if(luxury1 == 1)
        luxury = true;
        Theater t = new Theater(threeD, luxury, numSeats);
       
        String dummy = scan.nextLine(); // throw away new line character
        String title = scan.nextLine();
        t.setTitle(title);
       
        int basePrice = scan.nextInt();
        t.setBasePrice(basePrice);
       
        int N = scan.nextInt();
        for(int i = 0; i < N; ++i) {
        int numberOfSeats = scan.nextInt();
        int seatNumber = scan.nextInt();
        int totalPrice;
        if(numberOfSeats == 1)
        totalPrice = t.reserveOne(seatNumber);
        else
        totalPrice = t.reserveMultiple(numberOfSeats, seatNumber);
        if(totalPrice > 0)
        System.out.println(totalPrice);
        }
       
        t.printInfo();  
    }
}
class Theater {
    boolean threeD;
    boolean luxury;
    int numSeats;
    String title;
    int basePrice;

    boolean[] seats;
    public Theater(boolean threeD, boolean luxury, int numSeats){
        this.threeD = threeD;
        this.luxury = luxury;
        this.numSeats = numSeats;
        this.seats = new boolean[numSeats+1];
    }
    void setTitle(String title){
        if(title == null || "".equals(title)){
            System.out.println("invalid title");
        }else{
            this.title = title;
        }
    }
    void setBasePrice(int basePrice){
        if(basePrice <= 0){
            System.out.println("invalid price");
        }else{
            this.basePrice = basePrice;
        }
        
    }
    // Theater2
    int reserveOne(int seatNumber){
        if(0< seatNumber && seatNumber<= numSeats){
            if(!seats[seatNumber-1]){
                seats[seatNumber-1] = true;
                return basePrice;
            }else{
                System.out.println("sorry");
            }
        }else{
            System.out.println("sorry");
        }
        return -1;
    }
    int reserveMultiple(int numberOfSeats, int seatNumber){
        if(seatNumber>0 && seatNumber-1 +numberOfSeats <= numSeats){
            for(int i = seatNumber-1; i<seatNumber-1+numberOfSeats; i++){
                if(seats[i]){
                    System.out.println("sorry");
                    return  -1;
                }
            }
            for(int i = seatNumber-1; i<seatNumber-1+numberOfSeats; i++){
                seats[i] = true;
            }
            return numberOfSeats*basePrice;
            
        }else{
            System.out.println("sorry");
            return  -1;
        }
        
    }
    //

    void printInfo(){
        if(threeD){
            System.out.println("3D");
        }else{
            System.out.println("No 3D");
        }
        if(luxury){
            System.out.println("Luxury");
        }else{
            System.out.println("Standard");
        }
        
        System.out.println(seats.length-1);

        if(title == null || "".equals(title)){
            System.out.println("title is not set");
        }else{
            System.out.println(title);
        }
        if(basePrice <= 0){
            System.out.println("price is not set");
        }else{
            System.out.println(basePrice);
        }
    }
}
