import java.util.Scanner;

public class Theater1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int threeD1 = input.nextInt();
        int luxury1 = input.nextInt();
        int numSeats = input.nextInt();
        boolean threeD = false;
        boolean luxury = false;
        if(threeD1 == 1)
        threeD = true;
        if(luxury1 == 1)
        luxury = true;
        Theater t = new Theater(threeD, luxury, numSeats);

        String dummy = input.nextLine();// throw away a new line character
        String title = input.nextLine();
        if(title.compareTo("-1") == 0)
        t.setTitle(null);
        else
        t.setTitle(title);

        int basePrice = input.nextInt();
        t.setBasePrice(basePrice);
        t.printInfo();

        input.close();
    }
}

