
import java.util.Scanner;

public class FoodContents1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String foodName = input.next();
        String foodContent = input.next();
        int foodweight = input.nextInt();
        food f = new food(foodName, foodContent, foodweight);
        while(true){
            int command = input.nextInt();
            input.nextLine();
            if(command == 0){
                break;
            }
            else if(command == 1){
                f.printInfo();
            }else if(command == 2){
                foodContent = input.next();
                foodweight = input.nextInt();
                
                f.addContent(foodContent, foodweight);
            }
        }
        input.close();
    }
}
class food{
    String foodName;
    String foodContent;
    int foodWeight;

    public food(String foodName, String foodContent, int foodWeight) {
        this.foodName = foodName;
        this.foodContent = foodContent;
        this.foodWeight = foodWeight;
    }
    void addContent(String content, int weight){
        this.foodContent += " " + content;
        this.foodWeight += weight;
    }
    void printInfo(){
        System.out.println(foodName);
        System.out.println(foodWeight);
        System.out.println(foodContent);
    }
}