
import java.util.Scanner;

public class ShrinkAndExpand {
    static String ShrinkExpand(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.length() >1){
            if(str.charAt(0) == str.charAt(1)){
                System.out.print(str.charAt(0));
                return ShrinkExpand(str.substring(2)); 
            }
        }
        
        
        System.out.print(str.charAt(0)+""+str.charAt(0));
        return (str.length()>1)?ShrinkExpand(str.substring(1)): ShrinkExpand("");
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        ShrinkAndExpand.ShrinkExpand(str);
        input.close();
    }
}
