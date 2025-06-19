import java.util.Scanner;

public class RecursiveAdd {
    static String add(String num1, String num2, int inc){
        if(num1.isBlank() || num2.isBlank()){
            return (inc==0)?"":inc+"";
        }
        int x = Integer.parseInt(num1.charAt(num1.length()-1)+"");
        int y = Integer.parseInt(num2.charAt(num2.length()-1)+"");
        int a = (inc+x+y)%10;
        inc   = (inc+x+y)/10;
        return a+""+add(num1.substring(0,num1.length()-1), num2.substring(0,num2.length()-1), inc);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num1   = input.nextLine();
        String num2   = input.nextLine();
        int order = (num1.length()>num2.length())? num1.length():num2.length();
        String sum = RecursiveAdd.add(num1, num2, 0);
        StringBuffer sumf = new StringBuffer();
        sumf.append(sum);
        System.out.println(sumf.reverse());
        input.close();
    }
}
