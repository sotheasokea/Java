
import java.util.Scanner;

public class GoInside {
    String goInside(String str, boolean front){
        if(str.isEmpty())   return "";
        if(str.length() <= 1){
            return str;
        }
        if(front){
            // System.out.print(str.charAt(0)+""+str.charAt(str.length()-1));
            String s = str.charAt(0)+""+str.charAt(str.length()-1);
            return s+goInside(str.substring(1,str.length()-1), false);
        }
        // System.out.print(str.charAt(str.length()-1)+""+str.charAt(0));
        String s = str.charAt(str.length()-1)+""+str.charAt(0);
        return s+goInside(str.substring(1,str.length()-1), true);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        String str = input.nextLine(); 
        GoInside obj = new GoInside();
        String newStr= obj.goInside(str, true);
        System.out.println(newStr);
        input.close();
    }
}
