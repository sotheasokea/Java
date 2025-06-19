
import java.util.Scanner;

public class IncreasingString {
    String makeIncreasintString(String str, char lastPrint){
        if(str.isBlank()){
            return "";
        }
        if(str.charAt(0) == 'A'){
            System.out.print("A");
            return makeIncreasintString(str.substring(1), 'A');
        }
        if(str.charAt(0)>lastPrint){
            System.out.print(str.charAt(0));
            lastPrint = str.charAt(0);
            return makeIncreasintString(str.substring(1), lastPrint);
        }
        return makeIncreasintString(str.substring(1), lastPrint);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        IncreasingString inString = new IncreasingString();
        inString.makeIncreasintString(str, 'A');
        input.close();
    }
}
