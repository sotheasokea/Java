
import java.util.Scanner;

public class SMSEncode {
    static void encode(String str, char ichar){
        // if(str.length() == 1 || str.isEmpty()){
        //     return;
        // }
        // if(ichar == -1){
        //     System.out.print("1 1 ");   
        // }
        // if(str.length() >2){
        //     ichar = (int)str.charAt(0);
        //     int first = (int)str.charAt(1) - ichar;
        //     int last  = (int)str.charAt(str.length()-1)-ichar;
        //     if(str.length()>3) System.out.print(last+" "+first+" ");
        //     else System.out.print(first+" ");
        // }
        // if(str.length() >2){
        //     ichar = (int)str.charAt(0);
        //     encode(str.substring(1,str.length()-1), ichar);
        // }
        if(str.length() < 2){
            return;
        }
        char firstChar = str.charAt(0);
        char lastChar  = str.charAt(str.length()-1);

        int num1 = firstChar - ichar;
        int num2 = lastChar  - firstChar;

        System.out.println(((num1==0)?1:num1)+" "+num2);
        encode(str.substring(1,str.length()-1), firstChar);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str    = input.nextLine();
        SMSEncode.encode(str, (char)64);
        input.close();
    }
}
