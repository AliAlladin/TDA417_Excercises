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
        int lowerBound = 0;
        int upperBound = 10001;
        int guess;

        while (true){

            guess = lowerBound + random.nextInt(upperBound - lowerBound);

            System.out.println("Is the number " + guess + "?");

            if (input.equals("h")){
                lowerBound = guess;
            }
            else if (input.equals("l")){
                upperBound = guess;
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
