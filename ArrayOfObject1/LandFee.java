
import java.util.ArrayList;
import java.util.Scanner;

public class LandFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numLandDeal = input.nextInt();
        input.nextLine();
        ArrayList<Bill> bill = new ArrayList<>();
        for(int i = 0; i<numLandDeal; i++){
            String pin = input.next();
            String saleDate = input.next();
            int landSize = input.nextInt();
            int landPrice= input.nextInt();
            input.nextLine();
            bill.add(new Bill(pin, saleDate, landSize, landPrice));
        }
        for(int i = 0; i<bill.size(); i++){
            bill.get(i).printInfo();
        }

        input.close();
    }
}
class Bill{
    String pin; // pin = percel Indetification Number
    String saleDate; // day/month/year
    int landSize;
    int landPrice; // in one squre wah
    double tax; // 3% of total price
    double fee; // 5% of total price
    double stamp; // 1% of total price
    Bill(String pin, String saleDate,int landSize,int landPrice){
        this.pin = pin;
        this.saleDate = saleDate;
        this.landSize = landSize;
        this.landPrice = landPrice;
        this.tax   = 0.03 * this.landPrice*landSize;
        this.fee   = 0.05 * this.landPrice*landSize;
        this.stamp = 0.01 * this.landPrice*landSize;
    }
    void printInfo(){
        System.out.println(pin+" "+saleDate+" "+landSize+" "+landPrice);
        System.out.printf("%.1f+%.1f+%.1f=%.1f",tax,fee,stamp,(tax+fee+stamp));
        System.out.println();
    }
}