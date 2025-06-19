import java.util.Scanner;

public class ItemAndCart2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String productName = input.next();
        String productCode = input.next();
        int price = input.nextInt();
        int shippingCost = input.nextInt();
        int volume = input.nextInt();
        int proInStock = input.nextInt();
        Items1 items1 = new Items1(productName, productCode, price, shippingCost, volume, proInStock);
        // Cart
        int boxVolume = input.nextInt();
        Cart carts = new Cart(boxVolume, items1);
        int numRequest = input.nextInt();
        for(int i = 0; i<numRequest; i++){
            int proToCart = input.nextInt();
            System.out.println(carts.adjustQuan(proToCart));
            carts.printStats();
        }
        input.close();
    }
}
class Cart{
    int boxVolume;
    Items1 item;
    private int boxUsed;
    private int proInCart;

    Cart(int boxVolume, Items1 item) {
        this.boxVolume = boxVolume;
        this.item = item;
        this.proInCart = 0;
    }
    void printStats(){
        int totalProPrize = item.price*proInCart;
        int totalShipping = item.shippingCost*proInCart;
        System.out.print(proInCart+" "+totalProPrize+" "+totalShipping);
        if(proInCart == 0){
            boxUsed = 0;
            System.out.print(" "+(totalProPrize+totalShipping));
            System.out.println(" "+0);
        }
        else if(boxVolume >= proInCart*item.volume){
            boxUsed = 1;
            System.out.print(" "+(totalProPrize+totalShipping));
            System.out.println(" "+boxUsed);
        }else if(boxVolume < proInCart*item.volume){
            boxUsed = 2;
            System.out.print(" "+(totalProPrize+totalShipping));
            System.out.println(" "+boxUsed+"+");
        }
        boxUsed = 0;
        // System.out.println("Product in stock : "+item.proInStock);
    }
    boolean adjustQuan(int proToCart){
        // proToCart positive = add product to Cart
        if(proToCart > 0){
            boolean added = item.cutStock(proToCart);
            if(added){
                proInCart += proToCart;
                return added;
            }
        }else if(proToCart < 0){
            if(proInCart < Math.abs(proToCart)){
                return false;
            }else{
                item.proInStock += Math.abs(proToCart);
                proInCart += proToCart;
                return true;
            }
        }
        return false;
    }
}