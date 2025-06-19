import java.util.Scanner;

public class SUGlodShop2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCustomer = input.nextInt();
        double priceToday  = input.nextDouble();
        Item[] gold = new Item[numCustomer];
        for(int i = 0; i<numCustomer; i++){
            char command = input.next().charAt(0);
            char goldType = input.next().charAt(0);
            double goldWeight = input.nextDouble();
            gold[i] = new Item(goldType, goldWeight);
            if(command == 's'){
                 gold[i].showDetail(priceToday);
                 System.out.println("sale "+gold[i].salePrice(priceToday));
            }else if(command == 'b'){
                gold[i].showDetail(priceToday);
                System.out.println("buy "+gold[i].buyPrice(priceToday));
            }
        }

        input.close();
    }
}
