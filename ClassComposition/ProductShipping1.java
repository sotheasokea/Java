
import java.util.Scanner;

public class ProductShipping1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numProduct= input.nextInt();    input.nextLine();
        for(int i = 0; i<numProduct; i++){
            String proName = input.next();
            int weight = input.nextInt();
            int price  = input.nextInt();
            Product products = new Product(proName, weight, price);
            products.printInfo();
        }
        input.close();
    }
}
// class Product{
//     String proName;
//     int weight;
//     int price;
//     Product(String proName, int weight, int price){
//         this.proName = proName;
//         this.weight  = weight;
//         this.price   = price;
//     }
//     void printInfo(){
//         System.out.println(weight+" grams of "+proName+" costs "+price+" baht.");
//     }
// }