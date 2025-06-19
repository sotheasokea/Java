import java.util.ArrayList;
import java.util.Scanner;
public class EnDecoder2 {
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
        Encoder2 encoders = new Encoder2(vocabulary, vocabularyCode);
        int numFindword = input.nextInt(); input.nextLine();
        ArrayList<String> findWord = new ArrayList<>();
        for(int i = 0; i<numFindword; i++){
            String word = input.next();
            findWord.add(word);
        }
        encoders.encodeMsg(findWord);
        Decoder decoder = new Decoder(encoders);
        decoder.decodeMsg(encoders.encoded);
        
        input.close();
    }
}
class Decoder{
    Encoder2 encoder;
    Decoder(Encoder2 encoder){
        this.encoder = encoder;
    }
    private String decodeWord(int code){
        int index = 0;
        for(int c: encoder.vocEncoded){
            if(code == c){
                return this.encoder.vocabulary.get(index);
            }
            index++;
        }
        return "?";
    }
    void decodeMsg(ArrayList<Integer> code){
        ArrayList<String> wordOut = new ArrayList<>();
        for(int c: code){
            wordOut.add(decodeWord(c));
        }
        for(String w: wordOut){
            System.out.print(w+" ");
        }
    }
}
class Encoder2{
    ArrayList<String> vocabulary;
    ArrayList<Integer> vocEncoded;
    ArrayList<Integer> encoded;
    Encoder2(ArrayList<String> vocabulary, ArrayList<Integer> vocEncoded){
        this.vocabulary = new ArrayList<>(vocabulary);
        this.vocEncoded = new ArrayList<>(vocEncoded);
        this.encoded =  new ArrayList<>();
    }
    private int encodeWord(String word){
        int index = 0;
        for(String w: this.vocabulary){
            if(w.equals(word)){
                return this.vocEncoded.get(index);
            }
            index++;
        }
        return -1;
    }
    void encodeMsg(ArrayList<String> vocabulary){
        for(String word: vocabulary){
            this.encoded.add(encodeWord(word));
        }
        // for(int code: encoded){
        //     System.out.print(code+" ");
        // }
    }
}
