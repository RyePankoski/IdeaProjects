import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class finalAli {

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner skan = new Scanner(System.in);

        int[] randomArray = new int[ran.nextInt(10)];



        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = ran.nextInt(1,100);
        }

        int min = randomArray[0];
        int max = 0;


      for (int i = 0; i < randomArray.length; i++) {
        if (randomArray[i] > max) {
            max = randomArray[i];
        }
        if (randomArray[i] < min) {
            min = randomArray[i];
        }
       }

        while (true) {

            System.out.println("Guess a number");
            int guess = skan.nextInt();
            ;

            if (guess > max) {
                System.out.println("This is larger than any number in the array!");
            }
            if (guess < min) {
                System.out.println("This is smaller than any number in the array!");
            }

            for (int i = 0; i < randomArray.length; i++) {
                if (guess == randomArray[i]) {
                    System.out.println("You guessed correctly!");
                    System.out.println(Arrays.toString(randomArray));
                    System.exit(0);
                }
            }
            if (guess > min && guess < max) {
                System.out.println("This is in range");
            }
        }
    }
}
