
import java.util.ArrayList;
import java.util.Scanner;

public class Store1_FindBestDeal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String proName= input.nextLine();
        int numOfPrice= input.nextInt();
        ArrayList<Integer> price = new ArrayList<>(numOfPrice);
        for(int i = 0; i<numOfPrice; i++){
            int p = input.nextInt();
            price.add(p);
        }
        ProductInfo1 products = new ProductInfo1(proName, price);
        products.printInfo();

        input.close();
    }
}
class ProductInfo1{
    String proName;
    int cheapest;
    int mostExpensive;
    ProductInfo1(String proName,ArrayList<Integer> price){
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