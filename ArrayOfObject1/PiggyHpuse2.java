
import java.util.ArrayList;
import java.util.Scanner;
public class PiggyHpuse2 {
    public static void main(String[] args) {
        House.encourage();
        Scanner input = new Scanner(System.in);
        int numHouse = input.nextInt();
        ArrayList<House> house = new ArrayList<House>();
        for(int i = 0; i<numHouse; i++){
            int width = input.nextInt();
            int length= input.nextInt();
            int pigInHouse = input.nextInt();
            String houseName = input.next();
            house.add(new House(width, length, pigInHouse, houseName));
        }
        int houseNumber;
        OUTER: 
        while (true) {
            int command = input.nextInt();
            switch (command) {
                case 0:// end programm
                    break OUTER;
                case 1:// check houseNumber-1 to print info
                    houseNumber = input.nextInt();
                    house.get(houseNumber-1).printPiggies();
                    break;
                case 2:// add pigs to a house
                    houseNumber = input.nextInt();
                    int pigIn = input.nextInt();
                    boolean added = house.get(houseNumber-1).addPiggies(pigIn);
                    if(added){
                        house.get(houseNumber-1).printPiggies();
                    }else{
                        System.out.println("Sorry");
                    }
                    break;
                case 3:// removed pigs from house
                    houseNumber = input.nextInt();
                    int pigOut = input.nextInt();
                    int numPigRemoved = house.get(houseNumber-1).removePiggies(pigOut);
                    System.out.println("remove "+numPigRemoved+" from "+house.get(houseNumber-1).houseName);
                    break;
                case 4:// remove pigs from one house to another one
                    houseNumber = input.nextInt();
                    int newHouseNumber = input.nextInt();
                    int pigs = input.nextInt();

                    int movePigNum = house.get(houseNumber-1).removePiggies(pigs);
                    if(house.get(newHouseNumber-1).addPiggies(movePigNum)){
                        System.out.println("move "+movePigNum+" piggies from "+house.get(houseNumber-1).houseName+" to "+house.get(newHouseNumber-1).houseName);
                    }else{
                        house.get(houseNumber-1).addPiggies(movePigNum);
                        System.out.println("Unsuccessful");
                    }
                    break;
                default:
                    break;
            }
        }

        input.close();
    }
}
class House{
    int width;
    int length;
    int pigInHouse;
    String houseName;
    
    public House(int width, int length) {
        this.width  = width;
        this.length = length;
    }
    //
    House(int width, int length, int pigInHouse, String houseName){
        this.width = width;
        this.length = length;
        this.pigInHouse = pigInHouse;
        this.houseName = houseName;
        System.out.println(this.houseName+", Width "+this.width+", Length "+this.length+", Piggies "+this.pigInHouse);
    }
    boolean addPiggies(int pigIn){
        int checkPig = 9*(pigInHouse+pigIn);
        if(checkPig <= width*length){
            pigInHouse += pigIn;
            return true;
        }else{
            return false;
        }
    }
    int removePiggies(int pigOut){
        if(pigInHouse - pigOut >= 0){
            pigInHouse -= pigOut;
            return pigOut;
        }else{
            int removed = pigInHouse;
            pigInHouse = 0;
            return removed;
        }
    }
    void printPiggies(){
        System.out.println(houseName+", Piggies "+pigInHouse+", Used "+9*pigInHouse+", Left "+((width*length)-9*pigInHouse));
    }
    static void encourage(){
        System.out.println("Piggy Together STRONG!");
    }
    
}