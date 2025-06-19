
import java.util.Scanner;

public class CutHalfRecursive {
    
    static String Cut(String str){
        if(str.isEmpty()){
            return "";
        }
        int mid = str.length()/2;
        String midHalf = str.charAt(mid)+"";
        String firstHalf = str.substring(0,mid);
        String SecondHalf= str.substring(mid+1);
        return midHalf+Cut(firstHalf)+Cut(SecondHalf);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int middle = str.length()/2;
        String newStr = str.charAt(middle)+"";
        String result = CutHalfRecursive.Cut(str);
        System.out.println(result);
        
        input.close();
    }
}
