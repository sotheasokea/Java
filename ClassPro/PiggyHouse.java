
import java.util.Scanner;

public class PiggyHouse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        House.encourage();
        int width = input.nextInt();
        int length = input.nextInt();
        House house = new House(width, length);
        
        while(true){
            int pigFamilyMember = input.nextInt();
            if(9*(pigFamilyMember+house.pigInHouse) <= width*length){
                house.pigInHouse += pigFamilyMember;
                house.printPiggies();
            }else{
                System.out.println("no space, need a new house");
                break;
            }
            
        }
        input.close();
    }
}
// class House{
//     int width;
//     int length;
//     int pigInHouse;

//     public House(int width, int length) {
//         this.width  = width;
//         this.length = length;
//     }
//     void printPiggies(){
//         System.out.println("Piggies "+pigInHouse+", Space "+ 9*pigInHouse);
//     }
//     static void encourage(){
//         System.out.println("Piggy Together STRONG!");
//     }
    
// }
