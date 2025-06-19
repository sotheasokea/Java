
import java.util.Scanner;

public class FoodContents2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String foodName = input.next();
        String foodContent = input.next();
        int foodweight = input.nextInt();
        int foodCalories = input.nextInt();
        Food F = new Food(foodName, foodContent, foodweight, foodCalories);
        while(true){
            int command = input.nextInt();
            input.nextLine();
            if(command == 0){
                break;
            }
            else if(command == 1){
                F.printInfo();
            }else if(command == 2){
                foodContent = input.next();
                foodweight = input.nextInt();
                foodCalories = input.nextInt();
                
                F.addContent(foodContent, foodweight, foodCalories);
            }
        }
        input.close();
    }
}
class Food{
    String foodName;
    String foodContent;
    int foodWeight;
    int foodCalories;

    Food(String foodName, String foodContent, int foodWeight, int foodCalories) {
        this.foodName = foodName;
        this.foodContent = foodContent;
        this.foodWeight = foodWeight;
        this.foodCalories = foodCalories*foodWeight;
    }
    void addContent(String content, int weight, int calories){
        this.foodContent += " " + content;
        this.foodWeight += weight;
        this.foodCalories += calories*weight;
    }
    void printInfo(){
        System.out.println(foodName);
        System.out.println(foodWeight+" "+foodCalories);
        System.out.println(foodContent);
    }
}