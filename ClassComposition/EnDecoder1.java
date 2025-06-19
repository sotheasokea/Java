
import java.util.ArrayList;
import java.util.Scanner;

public class EnDecoder1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numWord = input.nextInt();  input.nextLine();
        ArrayList<String> vocabulary = new ArrayList<>();
        for(int i = 0; i<numWord; i++){
            String voc = input.next();
            vocabulary.add(voc);
        }
        ArrayList<Integer> vocabularyCode = new ArrayList<>();
        for(int i = 0; i<numWord; i++){
            int code = input.nextInt();
            vocabularyCode.add(code);
        }
        Encoder encoders = new Encoder(vocabulary, vocabularyCode);
        int numFindword = input.nextInt(); input.nextLine();
        ArrayList<String> findWord = new ArrayList<>();
        for(int i = 0; i<numFindword; i++){
            String word = input.next();
            findWord.add(word);
        }
        encoders.encodeMsg(findWord);
        input.close();
    }
}
class Encoder{
    ArrayList<String> vocabulary;
    ArrayList<Integer> vocEncoded;
    Encoder(ArrayList<String> vocabulary, ArrayList<Integer> vocEncoded){
        this.vocabulary = new ArrayList<>(vocabulary);
        this.vocEncoded = new ArrayList<>(vocEncoded);
    }
    private int encodeWord(String word){
        boolean found = false;
        int index = 0;
        for(String w: this.vocabulary){
            if(w.equals(word)){
                found = true;
                return this.vocEncoded.get(index);
            }
            index++;
        }
        return -1;
    }
    void encodeMsg(ArrayList<String> vocabulary){
        ArrayList<Integer> encoded = new ArrayList<>();
        for(String word: vocabulary){
            encoded.add(encodeWord(word));
        }
        for(int code: encoded){
            System.out.print(code+" ");
        }
    }
}