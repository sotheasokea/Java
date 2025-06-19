
import java.util.Scanner;

public class Items1AndCart1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String productName = input.next();
        String productCode = input.next();
        int price = input.nextInt();
        int shippingCost = input.nextInt();
        int volume = input.nextInt();
        int proInStock = input.nextInt();
        Items1 items1 = new Items1(productName, productCode, price, shippingCost, volume, proInStock);
        items1.printInfo();
        int numProOut = input.nextInt();
        for(int i = 0; i<numProOut; i++){
            int productOut = input.nextInt();
            System.out.println(items1.cutStock(productOut));
            items1.printInfo();
        }

        input.close();
    }
}
class Items1{
    String productName;
    String productCode;
    int price;
    int shippingCost;
    int volume;
    int proInStock;
    boolean valid;

    Items1(String productName, String productCode, int price, int shippingCost, int volume, int proInStock) {
        this.productName = productName;
        this.productCode = productCode;
        this.price = price;
        this.shippingCost = shippingCost;
        this.volume = volume;
        this.proInStock = proInStock;
        this.valid = basicCheck(productName, productCode, price, shippingCost, volume);
    }
    boolean basicCheck(String productName, String productCode, int price, int shippingCost, int volume){
        if(this.productCode == null || this.productName== null || this.productCode.length() <3 || this.productName.length()<3){
            return false;
        }
        if(this.price <0 || this.shippingCost <0 || this.volume<0){
            return false;
        }
        return true;
    }   
    boolean cutStock(int productOut){
        if(productOut > this.proInStock){
            return false;
        }
        this.proInStock -= productOut;
        return true;
    }
    void printInfo(){
        System.out.println(productName+" "+productCode+" "+price);
        System.out.println(shippingCost+" "+volume+" "+proInStock+" "+valid);
    }

    
}