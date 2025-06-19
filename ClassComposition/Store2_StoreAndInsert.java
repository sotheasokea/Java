import java.util.ArrayList;
import java.util.Scanner;
public class Store2_StoreAndInsert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numProduct= input.nextInt();
        Store store = new Store();
        for(int i = 0; i<numProduct; i++){
            store.enterProductInfo(input);
        }
        store.printAllProductInfo();
        input.close();
    }
}
class Store{
    private ArrayList<ProductInfo> products;
    Store(){
        this.products = new ArrayList<>();
    }
    void enterProductInfo(Scanner input){
        input.nextLine();
        String proName= input.nextLine();
        int numOfPrice= input.nextInt();
        ArrayList<Integer> price = new ArrayList<>(numOfPrice);
        for(int i = 0; i<numOfPrice; i++){
            int p = input.nextInt();
            price.add(p);
        }
        this.products.add(new ProductInfo(proName, price));
    }
    void printAllProductInfo(){
        for(ProductInfo p: products){
            p.printInfo();
        }
    }
}
class ProductInfo{
    String proName;
    int cheapest;
    int mostExpensive;
    ProductInfo(String proName,ArrayList<Integer> price){
        this.proName = proName;
        this.cheapest= Integer.MAX_VALUE;
        this.mostExpensive = Integer.MIN_VALUE;
        for(int p: price){
            if(p<this.cheapest){
                this.cheapest = p;
            }
            if(p>this.mostExpensive){
                mostExpensive = p;
            }
        }
    }
    void printInfo(){
        System.out.println(proName+" "+cheapest+" "+mostExpensive);
    }

}