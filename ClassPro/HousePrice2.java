
import java.util.Scanner;
public class HousePrice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfHouse = input.nextInt();
        House1[] house = new House1[numOfHouse];
        for(int i = 0; i<numOfHouse; i++){
            int landSize = input.nextInt();
            int quality = input.nextInt();
            int floors = input.nextInt();
            int houseArea = input.nextInt();
            house[i] = new House1(landSize, quality, floors, houseArea);
        }
        // price and area that customer want to buy
        int maxPrice = input.nextInt();
        int maxArea = input.nextInt();
        boolean found = false;
        for(int i = 0; i<numOfHouse; i++){
            if(house[i].price <= maxPrice && house[i].houseArea >= maxArea){
                house[i].display();
                found = true;
            }
        }
        if(!found){
            System.out.println("none");
        }
        input.close();
    
    }
}
