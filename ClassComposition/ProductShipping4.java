import java.util.ArrayList;
import java.util.Scanner;

public class ProductShipping4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        Truck[] trucks = new Truck[m];
        for (int i=0;i<m;i++){
        int capacity = in.nextInt();
        int type = in.nextInt();
        if (type==1)
        trucks[i] = new Truck(capacity);
        else
        trucks[i] = new SpecialTruck(capacity);
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
        int amount1 = in.nextInt();
        amount.add(amount1);
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
        System.out.println("Fee="+ trucks[minIndex].getFee());
        }else{
        System.out.println("No truck");
        double fee = po.totalweight*dest/1000.0;
        System.out.println("Fee="+ fee +" "+(2*fee));
        }
    } 
}
class Truck{
    int capacity;
    int shipTo_;
    double shippingCost;
    PurchaseOrder orders;
    Truck() { // Default constructor
        this.capacity = 0;
        this.shipTo_ = 0;
        this.shippingCost = 0.0;
        this.orders = new PurchaseOrder(0, new ArrayList<>(), new ArrayList<>());
    }
    Truck(int capacity){
        this.capacity = capacity;
        this.shipTo_ = 0;
        this.shippingCost = 0.0;
    }
    void add(PurchaseOrder orders,int shipTo_){
        this.orders = orders;
        this.shipTo_= shipTo_;
        setFee();
    }
    void setFee(){
        shippingCost = shipTo_*orders.totalweight/1000.0;
    }
    double getFee(){
        return shippingCost;
    }
}
class SpecialTruck extends Truck{
    SpecialTruck(int capacity) {
        super(capacity);  // Calls Truck's constructor
    }
    void add(PurchaseOrder orders, int shipTo_) {
        this.orders = orders;
        this.shipTo_ = shipTo_;
        setFee();  // Ensure it calls the overridden setFee()
    }
    void setFee(){
        double weightKG = (double)orders.totalweight/1000.0;
        shippingCost = 2*weightKG*(double)shipTo_;
    }
}
class PurchaseOrder{
    int numProduct;
    ArrayList<Product> products;
    ArrayList<Integer> quanity;
    int totalPrice;
    int totalweight;
    PurchaseOrder(int numProduct, ArrayList<Product> products, ArrayList<Integer> quanity){
        this.numProduct = numProduct;
        this.products = new ArrayList<>(products);
        this.quanity  = new ArrayList<>(quanity);
        this.totalPrice = 0;
        this.totalweight= 0;
        int cnt = 0;
        for(Product pro: this.products){
            this.totalPrice += pro.price*this.quanity.get(cnt);
            this.totalweight+= pro.weight*this.quanity.get(cnt);
            cnt++;
        }
    }
    void printInfo(){
        System.out.println(numProduct+" items = "+totalPrice+" baht "+totalweight+" grams");
        int cnt = 0;
        for(Product pro: products){
            int proPrice = quanity.get(cnt)*pro.price;
            System.out.println(pro.proName+" "+quanity.get(cnt)+"x"+pro.price+" = "+proPrice);
            cnt++;
        }
    }

    
}
class Product{
    String proName;
    int weight;
    int price;
    Product(String proName, int weight, int price){
        this.proName = proName;
        this.weight  = weight;
        this.price   = price;
    }
    void printInfo(){
        System.out.println(weight+" grams of "+proName+" costs "+price+" baht.");
    }
}