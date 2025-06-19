
import java.util.Scanner;

public class SUGoldShop1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCustomer = input.nextInt();
        double priceToday  = input.nextDouble();
        Item[] gold = new Item[numCustomer];
        double weightSale = 0.0,totalSale = 0.0;
        double weightBuy = 0.0,totalBuy = 0.0;
        for(int i = 0; i<numCustomer; i++){
            char command = input.next().charAt(0);
            char goldType = input.next().charAt(0);
            double goldWeight = input.nextDouble();
            gold[i] = new Item(goldType, goldWeight);
            if(command == 's'){
                weightSale += gold[i].goldWeight;
                totalSale  += gold[i].salePrice(priceToday);
            }else if(command == 'b'){
                weightBuy  += gold[i].goldWeight;
                totalBuy   += gold[i].buyPrice(priceToday);
            }
        }
        System.out.println(weightSale+" "+totalSale);
        System.out.println(weightBuy+" "+totalBuy);
        input.close();
    }
}
class Item{
    boolean goldType; // true = ornament , false = bar
    double goldWeight;
    Item(char  gold, double goldWeight){
        if(gold == 't'){
            this.goldType = true;
        }else if(gold == 'f'){
            this.goldType = false;
        }
        this.goldWeight = goldWeight;
    }

    Item(int goldWeight) {
        this.goldWeight = goldWeight;
    }
    Double salePrice(double goldPrice){
        if(goldType){
            return (goldPrice*this.goldWeight + 1000*this.goldWeight);
        }
        return (goldPrice*this.goldWeight );
    
    }
    Double buyPrice(double goldPrice){
        if(goldType){
            return (goldPrice)*this.goldWeight*(0.98);
        }
        return (goldPrice-100)*this.goldWeight;
    }
    void showDetail(double goldPrice){
        if(goldType){
            System.out.print("ornament "+this.goldWeight+" baht ");
        }else{
            System.out.print("bar "+this.goldWeight+" baht ");     
        }
    }
}