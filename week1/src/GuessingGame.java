import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        new GuessingGame().program();
    }

    private void program() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        welcomeMessage();

        String input = "";
        while (!input.contains("s")){
            System.out.print("> ");
            input = scanner.nextLine();
        }

        int counter = 1;
        int lo = 0;
        int hi = 10001;
        int guess;

        while (lo <= hi){

            guess = lo + random.nextInt(hi - lo);

            System.out.println("Is the number " + guess + "?");

            if (input.equals("h")){
                lo = guess;
            }
            else if (input.equals("l")){
                hi = guess;
            }
            else if (input.equals("c")){
                System.out.println("YAY, it took me " + counter + " guesses to get it right!");
                break;
            }
            counter++;
        }
    }

    private void welcomeMessage(){
        System.out.println("------------------------------------------------");
        System.out.println("|                Guessing game                 |");
        System.out.println("| Controls: c = correct, h = higher, l = lower |");
        System.out.println("------------------------------------------------");

        System.out.println("Think of a number between 1 and 10000, when ready type (s)tart!");

    }
}
