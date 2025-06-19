import java.util.Scanner;

public class BackAndForth {
    static String record(String word, boolean forward){
        if(!word.contains("A")){
            String s ="";
            if(!forward){
                for(int i = word.length()-1; i>=0; i--){
                    s+= word.charAt(i);
                }
                word = s;
            }
            // System.err.println(word);
            return word;
        }
        if(word.isEmpty()){
            return "";
        }
        if(forward){
            int index = word.indexOf("A")+1;
            // System.out.println(word.substring(0, index));
            return word.substring(0, index) + record(word.substring(index), false);
        }else{
            int index = word.lastIndexOf("A");
            String str= "";
            for(int i = word.length()-1; i>= index; i--){
                str += word.charAt(i);
            }
            // System.out.println(str);
            return str + record(word.substring(0, index), true);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word   = input.nextLine();
        boolean forward = true;
        String newWord= BackAndForth.record(word, forward);
        System.out.println(newWord);
        input.close();
    }
}
