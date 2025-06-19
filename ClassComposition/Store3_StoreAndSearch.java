import java.util.ArrayList;
import java.util.Scanner;

public class Store3_StoreAndSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numProduct= input.nextInt();
        Store3 store = new Store3();
        for(int i = 0; i<numProduct; i++){
            store.enterProductInfo3(input);
        }
        // store.printAllProductInfo();
        input.nextLine();
        String findProductName = input.nextLine();
        ArrayList<String> pName = new ArrayList<>(store.getInfo(findProductName));
        if (pName.size() == 0) {
            System.out.println(pName.size());
            System.out.println("product not found");
        }else{
            System.out.println(pName.size());
            for(String n: pName){
                System.out.println(n);
            }
        }
        input.close();
    }
}
class Store3{
    private ArrayList<ProductInfo3> products;
    Store3(){
        this.products = new ArrayList<>();
    }
    void enterProductInfo3(Scanner input){
        input.nextLine();
        String proName= input.nextLine();
        int numOfPrice= input.nextInt();
        ArrayList<Integer> price = new ArrayList<>(numOfPrice);
        for(int i = 0; i<numOfPrice; i++){
            int p = input.nextInt();
            price.add(p);
        }
        this.products.add(new ProductInfo3(proName, price));
    }
    void printAllProductInfo3(){
        for(ProductInfo3 p: products){
            p.printInfo();
        }
    }
    ArrayList<String> getInfo(String name){
        ArrayList<String> pros = new ArrayList<>();
        for(ProductInfo3 p: this.products){
            if(p.proName.contains(name)){
                pros.add(p.proName+" "+p.cheapest+" "+p.mostExpensive);
            }
        }
        return pros;
    }
}
class ProductInfo3{
    String proName;
    int cheapest;
    int mostExpensive;
    
    ProductInfo3(String proName,ArrayList<Integer> price){
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