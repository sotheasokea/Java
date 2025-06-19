
import java.util.Scanner;

public class KeepTwo {
    static String keepTwoS(String str, String result){
        if(str.isEmpty()){
            return "";
        }
        int cnt = 0;
        for(int i = 0; i<result.length(); i++){
            if(result.charAt(i) == str.charAt(0)){
                cnt++;
            }
            if(cnt == 2)    break;
        }
        if(cnt != 2){
            System.out.print(str.charAt(0));
            result += str.charAt(0);
            return keepTwoS(str.substring(1), result);
        }
        return keepTwoS(str.substring(1), result);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        KeepTwo.keepTwoS(str, "");
        input.close();
    }
}
