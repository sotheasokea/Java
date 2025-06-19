import java.util.Scanner;

public class HousePrice1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int landSize = scan.nextInt();
        int quality = scan.nextInt();
        int floors = scan.nextInt();
        int houseArea = scan.nextInt();

        House1 house = new House1(landSize, quality, floors, houseArea);
        System.out.println(house.landSize + " " +
        house.quality + " " + house.floors + " " +
        house.houseArea);
        System.out.println(house.price);
        scan.close();
    }
}
class House1{
    int landSize;
    int quality;
    int floors;
    int houseArea;
    public int price;
    int computePrice(int landSize, int quality, int floors, int houseArea){
        int total = 0;
        total = 10000*landSize;
        if(floors > 1){
            total += 200000*(floors-1);
        }
        if(quality == 1){
            total += 10000*houseArea;
        }else if(quality == 2){
            total += 8000*houseArea;
        }else if(quality == 3){
            total += 5000*houseArea;
        }
        return total;
    }
    House1(int landSize, int quality, int floors, int houseArea){
        this.landSize = landSize;
        this.quality  = quality;
        this.floors   = floors;
        this.houseArea= houseArea;
        this.price    = computePrice(this.landSize, this.quality, this.floors, this.houseArea);
    }
    void display(){
        System.out.println(landSize + " " +quality + " " +floors + " " +houseArea +" "+ price);
    }
}