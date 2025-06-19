import java.util.Scanner;

public class BeautifulBrosBeautiful{
    public static void main(String[] args) {
    // Read all the inputs
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        String[] phrases = new String[K];
        scan.nextLine();
        for(int i = 0; i < K; ++i) {
            phrases[i] = scan.nextLine();
        }

        final int C = scan.nextInt();
        Audience[] Cs = new Audience[C+1];
        for(int p = 1; p <= C; ++p) {
            final int N = scan.nextInt();
            String[] msg = new String[N];
            scan.nextLine();
                for(int i = 0; i < N; ++i) {
                    msg[i] = scan.nextLine();
                }
                Cs[p] = new Audience(msg);
        }
        int cnt = 0;
        for(String str : phrases){
            if(str.equals("crack")){
                boolean found = false;
                for(int i = 1; i<= C; i++){
                    if(!Cs[i].disconnected && cnt < Cs[i].characterVoice.length){
                        if(!Cs[i].isBeautiful(cnt)){
                            found = true;
                            System.out.print(i +" ");
                        }
                    }else if(!Cs[i].disconnected && cnt >= Cs[i].characterVoice.length){
                        int k = cnt - (cnt/Cs[i].characterVoice.length)*Cs[i].characterVoice.length;
                        if(!Cs[i].isBeautiful(k)){
                            found = true;
                            System.out.print(i +" ");
                        }
                    }
                }
                if(!found){
                    System.out.println("x");
                }else{
                    System.out.println();
                }
            }
            cnt ++;
        }
    }
}
class Audience{
    String[] characterVoice;
    boolean disconnected;
    Audience(String[] characterVoice){
        this.characterVoice = characterVoice;
        this.disconnected   = false;
    }
    boolean isBeautiful(int p){
        if(characterVoice[p].equals("beautiful")){
            return true;
        }else{
            disconnected = true;
            return false;
        } 
    }
}