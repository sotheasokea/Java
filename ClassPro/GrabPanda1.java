
import java.util.Scanner;

public class GrabPanda1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.next();
        int numOfOrder = input.nextInt();
        FoodOrder order = new FoodOrder(name);

        for(int i = 0; i<numOfOrder; i++){
            int payment = input.nextInt();
            order.addFood(payment);
        }
        order.finalizeReciept();
        input.close();
    }
}
// class FoodOrder{
//     String custName;
//     int FoodTotal;
//     FoodOrder(String custName){
//         this.custName = custName;
//     }
//     void addFood(int payment){
//         FoodTotal += payment;
//     }
//     void finalizeReciept(){
//         System.out.println(custName);
//         System.out.println(FoodTotal);
//         if(FoodTotal <= 50){
//             System.out.println(20);
//             System.out.println(FoodTotal+20);
//         }else if(FoodTotal <= 150){
//             System.out.println(10);
//             System.out.println(FoodTotal+10);
//         }else{
//             System.out.println(0);
//             System.out.println(FoodTotal);
//         }
//     }
// }