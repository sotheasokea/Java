
import java.util.Scanner;

public class CookiePlan {
    static int planCookie(int[] flours, int[] butters){
        int day = 0;
        for(int i = 0; i<flours.length; i++){
            if(flours[i] < 60 || butters[i] < 30 ){
                System.out.println(i+1);
                day++;
            }
        }
        return day;
        }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfDay = input.nextInt();
        int[] flours = new int[numOfDay];
        int[] butters = new int[numOfDay];
        for(int i = 0; i<numOfDay; i++){
            flours[i]  = input.nextInt();
            butters[i] = input.nextInt();
        }
        int days = CookiePlan.planCookie(flours, butters);
        System.out.println("There are "+days+" days that ingredients are insufficient");
        

        input.close();
    }
}
