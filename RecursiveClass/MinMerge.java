
import java.util.Scanner;

public class MinMerge {
    String merge(String str1, String str2){
        if(str1.isEmpty()){
            return str2;
        }else if(str2.isEmpty()){
            return str1;
        }
        if(str1.charAt(0) < str2.charAt(0)){
            return str1.charAt(0)+merge(str1.substring(1), str2.substring(1));
        }
        return str2.charAt(0)+merge(str1.substring(1), str2.substring(1));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1   = input.nextLine();
        String str2   = input.nextLine();
        MinMerge minMerge = new MinMerge();
        String newWord= minMerge.merge(str1, str2);
        System.out.println(newWord);
        input.close();
    }
}
