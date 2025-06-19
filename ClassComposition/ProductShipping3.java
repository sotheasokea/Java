
import java.util.ArrayList;
import java.util.Scanner;

public class ProductShipping3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        Truck[] trucks = new Truck[m];
        for (int i=0;i<m;i++){
        int capacity = in.nextInt();
        trucks[i] = new Truck(capacity);
        }
        int n = in.nextInt();
        int dest = in.nextInt();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        for(int i=0;i<n;i++){
        String name = in.next();
        int weight = in.nextInt();
        int price = in.nextInt();
        products.add(new Product(name,weight,price));
        int amout1 = in.nextInt();
        amount.add(amout1);
        }
        PurchaseOrder po = new PurchaseOrder(n,products, amount);
        int minvalue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=0;i<m;i++){
       if((trucks[i].capacity>=po.totalweight)&&(minvalue>trucks[i].capacity)){
        minvalue = trucks[i].capacity;
        minIndex = i;
        }
        }
        if (minIndex >= 0){
        trucks[minIndex].add(po, dest);
        System.out.println("Truck#"+ (minIndex+1));
        // System.out.println("Fee="+ trucks[minIndex].getFee());
            double fee = trucks[minIndex].getFee();
            if (fee * 100 % 10 == 0) {
                System.out.printf("Fee=%.1f%n", fee);
            }
            else if (fee * 100 % 10 != 0) {
                System.out.printf("Fee=%.2f%n", fee);
            } else {
                System.out.printf("Fee=%.3f%n", fee);
            }
        }else{
        System.out.println("No truck");
        System.out.println("Fee="+ po.totalweight*dest/1000.0);
        }
        
    }
}
// class Truck{
//     int capacity;
//     int orderID;
//     int shipTo_;
//     double shippingCost;
//     PurchaseOrder orders;
//     Truck(int capacity){
//         this.capacity = capacity;
//         this.shipTo_ = 0;
//         this.shippingCost = 0.0;
//     }
//     void add(PurchaseOrder orders,int shipTo_){
//         this.orders = orders;
//         this.shipTo_= shipTo_;
//         setFee();
//         this.shippingCost = getFee();
//     }
//     void setFee(){
//         double weightKG = (double)orders.totalweight/1000.0;
//         shippingCost = weightKG*(double)shipTo_;
//     }
//     double getFee(){
//         return shippingCost;
//     }
// }