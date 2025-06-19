
import java.util.Scanner;

public class BracketChecking {
    static boolean CheckBracket(String expression){
        if(expression.isEmpty()){
            return true;
        }
        if(!expression.contains("{") && !expression.contains("}")){
            return true;
        }
        if(!expression.contains("{") || !expression.contains("}")){
            return false;
        }
        int index1 = expression.indexOf("{");
        int index2 = expression.indexOf("}",index1);
        if(index2 == -1){
            return false;
        }
        
        String newExpression  = expression.substring(0,index1) + expression.substring(index1+1,index2) + expression.substring(index2+1);
        return CheckBracket(newExpression);

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        System.out.println(BracketChecking.CheckBracket(expression));
        input.close();
    }
}
