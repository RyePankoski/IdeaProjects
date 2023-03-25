import java.util.Random;
import java.util.Scanner;

public class easyProblem {

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner skan = new Scanner(System.in);
        int numberToGuess = ran.nextInt(99);


        int userGuess = 0;
        int attempts = 0;
        char yesNo = ' ';
        boolean gamestate = true;

        while (gamestate) {



            System.out.println("Guess the number");
            userGuess = skan.nextInt();

            if (userGuess > numberToGuess) {
                System.out.println("That is too high!");
                attempts++;
            }
            if (userGuess < numberToGuess) {
                System.out.println("That is too low!");
                attempts++;
            }
            if (userGuess == numberToGuess) {
                System.out.println("That's correct!" + "\n" + "Your score is " + attempts + "!");
                System.out.println("Want to play again? y/n");
                yesNo = skan.next().charAt(0);

                if (yesNo == 'y') {
                    gamestate = true;
                    numberToGuess = ran.nextInt(99);
                    attempts = 0;
                } else {
                    System.out.println("Goodbye!");
                    break;
                }
            }

        }
    }
}
