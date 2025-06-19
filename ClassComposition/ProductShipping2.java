
import java.util.ArrayList;
import java.util.Scanner;

public class ProductShipping2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numProduct= Integer.parseInt(input.nextLine());
        ArrayList<Integer> quanity = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i<numProduct; i++){
            String proName = input.next();
            int weight = input.nextInt();
            int price  = input.nextInt();
            int amount = input.nextInt();
            quanity.add(amount);
            products.add(new Product(proName, weight, price));
        }
        PurchaseOrder orders = new PurchaseOrder(numProduct, products, quanity);
        orders.printInfo();

        input.close();
    }
}
// class PurchaseOrder{
//     int numProduct;
//     ArrayList<Product> products;
//     ArrayList<Integer> quanity;
//     int totalPrice;
//     int totalweight;
//     PurchaseOrder(int numProduct, ArrayList<Product> products, ArrayList<Integer> quanity){
//         this.numProduct = numProduct;
//         this.products = new ArrayList<>(products);
//         this.quanity  = new ArrayList<>(quanity);
//         this.totalPrice = 0;
//         this.totalweight= 0;
//         int cnt = 0;
//         for(Product pro: this.products){
//             this.totalPrice += pro.price*this.quanity.get(cnt);
//             this.totalweight+= pro.weight*this.quanity.get(cnt);
                // cnt++;
//         }
//     }
//     void printInfo(){
//         System.out.println(numProduct+" items = "+totalPrice+" baht "+totalweight+" grams");
//         int cnt = 0;
//         for(Product pro: products){
//             int proPrice = quanity.get(cnt)*pro.price;
//             System.out.println(pro.proName+" "+quanity.get(cnt)+"x"+pro.price+" = "+proPrice);
//             cnt++;
//         }
//     }

    
// }